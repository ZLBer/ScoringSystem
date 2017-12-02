package test.push;

import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;
import test.GlobalVariance;
import test.domain.Information;
import test.domain.InformationExample;
import test.mapper.InformationMapper;
import test.service.IGuardService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class MyWebHandler extends AbstractWebSocketHandler {
    @Resource
    InformationMapper informationMapper;

    @Resource
    IGuardService guardService;

    private final String TAG = "WebSocketHandler";

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String receivedMessage = message.getPayload();
        if (receivedMessage.substring(0, 10).equals("guardQuery")) {
            guardQueryInfo(session, receivedMessage.substring(10, receivedMessage.length()));
        } else if (receivedMessage.substring(0, 11).equals("guardSubmit")) {
            submitToReviewerNotice(session, receivedMessage.substring(11, receivedMessage.length()));
        } else if (receivedMessage.substring(0, 14).equals("reviewerSubmit")) {
            scoreNotice(session);
        }
    }
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println(TAG + "建立了连接 " + session.getId());
        GlobalVariance.SSessions[GlobalVariance.SEAT / 10][GlobalVariance.SEAT % 10] = session;
        //上线通知
        onLineNotice(session);
        //上线后需查询其他人的在线状态
        onLineFirstNotice(session);

    }
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("连接" + session.getId() + "关闭了 status: " + status);
        offLineNotice(session);

    }

    //广播消息
    private void broadcast(String room, String message) throws Exception {
        if (room.equals("A")) {
            WebSocketSession[] AsocketSession = GlobalVariance.SSessions[0];
            for (WebSocketSession socketSession : AsocketSession) {
                if (socketSession != null)
                    socketSession.sendMessage(new TextMessage(message));
            }
        } else if (room.equals("B")) {
            WebSocketSession[] AsocketSession = GlobalVariance.SSessions[1];
            for (WebSocketSession socketSession : AsocketSession) {
                if (socketSession != null)
                    socketSession.sendMessage(new TextMessage(message));
            }
        }
    }

    //下线通知
    private void offLineNotice(WebSocketSession session) throws Exception {
        for (int i = 0; i < 4; i++) {
            if (GlobalVariance.SSessions[0][i] == null) continue;
            if (session.getId() == GlobalVariance.SSessions[0][i].getId()) {
                GlobalVariance.SSessions[0][i] = null;
                broadcast("A", conditionSuccessJson(i, GlobalVariance.REVIEWER_OFFLINE));
                return;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (session.equals(GlobalVariance.SSessions[1][i])) {
                GlobalVariance.SSessions[1][i] = null;
                broadcast("B", conditionSuccessJson(i, GlobalVariance.REVIEWER_OFFLINE));
                return;
            }
        }
    }

    //上线后首先查询其他人的状态
    private void onLineFirstNotice(WebSocketSession session) throws Exception {

        for (int i = 0; i < 4; i++) {
            if (GlobalVariance.SSessions[0][i] == null) continue;
            if (session.getId() == GlobalVariance.SSessions[0][i].getId()) {
                for(int j=1; j<4;j++){
                    if (GlobalVariance.SSessions[0][j] == null) continue;
                   else
                    session.sendMessage(new TextMessage(conditionSuccessJson(j, GlobalVariance.REVIEWER_ONLINE)));
                }
              return;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (GlobalVariance.SSessions[1][i] == null) continue;
            if (session.getId() == GlobalVariance.SSessions[1][i].getId()) {
                for(int j=1; j<4;j++){
                    if(GlobalVariance.SSessions[1][j]!=null)
                        session.sendMessage(new TextMessage(conditionSuccessJson(j, GlobalVariance.REVIEWER_ONLINE)));
                }
                return;
            }
        }
    }

    //上线通知
    private void onLineNotice(WebSocketSession session) throws Exception {
        for (int i = 0; i < 4; i++) {
            if (GlobalVariance.SSessions[0][i] == null) continue;
            if (session.getId() == GlobalVariance.SSessions[0][i].getId()) {
                broadcast("A", conditionSuccessJson(i, GlobalVariance.REVIEWER_ONLINE));
                return;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (session.equals(GlobalVariance.SSessions[1][i])) {
                broadcast("B", conditionSuccessJson(i + 1, GlobalVariance.REVIEWER_ONLINE));
                return;
            }
        }
    }

    //提交评委通知
    private void submitToReviewerNotice(WebSocketSession session, String serialNumber) throws Exception {

        InformationExample example = new InformationExample();
        InformationExample.Criteria criteria = example.createCriteria();
        criteria.andSerialNumberEqualTo(serialNumber + "");
        List<Information> inf = informationMapper.selectByExample(example);
        Information information = inf.get(0);
        String jsonStr = infoSuccessJson(information.getSerialNumber(), information.getExamNumber(), information.getDominantTerm(), information.getSecondaryTerm(), information.getSightsinging());
        if (session.getId() == GlobalVariance.SSessions[0][0].getId()) {
            for (int i = 1; i < 4; i++)
                if (GlobalVariance.SSessions[0][i] != null)
                    GlobalVariance.SSessions[0][i].sendMessage(new TextMessage(jsonStr));

        } else if (session.getId() == GlobalVariance.SSessions[1][0].getId()) {
            for (int i = 1; i < 4; i++)
                if (GlobalVariance.SSessions[1][i] != null)
                    GlobalVariance.SSessions[1][i].sendMessage(new TextMessage(jsonStr));
        }
    }

    //评分通知
    private void scoreNotice(WebSocketSession session) throws Exception {
        for (int i = 0; i < 4; i++) {
            if (GlobalVariance.SSessions[0][i] == null) continue;
            if (session.getId() == GlobalVariance.SSessions[0][i].getId()) {
                broadcast("A", conditionSuccessJson(i, GlobalVariance.REVIEWER_SCORE));
                return;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (GlobalVariance.SSessions[0][i] == null) continue;
            if (session.getId() == GlobalVariance.SSessions[1][i].getId()) {
                broadcast("B", conditionSuccessJson(i, GlobalVariance.REVIEWER_SCORE));
                return;
            }
        }
    }

    //进场控制人查询人员
    private void guardQueryInfo(WebSocketSession session, String serialNumber) throws Exception {
        //判断该学生是否抽号
        Information information = guardService.getInformationBySerialNumber(serialNumber);
        if (information == null) {
            session.sendMessage(new TextMessage(failJson("该学生暂未抽号！")));
        } else {
            session.sendMessage(new TextMessage(infoSuccessJson(information.getSerialNumber(), information.getExamNumber(), information.getDominantTerm(), information.getSecondaryTerm(), information.getSightsinging())));

        }
    }


    //private String conditionSuccessJson(int reviewer1,int reviewer2,int reviewer3,String serialNumber,String examNumber,String dominantTerm,String secondaryTerm,String sightsinging){
//
//        String s="{ \"status \": \"success\" , \"reviewer1\": \""+reviewer1+"\", \"reviewer2\": \""+reviewer2+"\", \"reviewer3\": \""+reviewer3+"\",  \"serialNumber\": \"" + serialNumber + "\", \"examNumber\": \"" + examNumber + "\",\"dominantTerm\": \""+dominantTerm+"\",\"secondaryTerm\": \"" + secondaryTerm + "\",\"sightsinging\": \"" + sightsinging + "\"}";
//
//        return s;
//    }
//    //构造评委状态字符串
//      private String conditionSuccessJson(int reviewer1,int reviewer2,int reviewer3){
//
//          String s="{ \"code\": \"cond\" , \"reviewer1\": \""+reviewer1+"\", \"reviewer2\": \""+reviewer2+"\", \"reviewer3\": \""+reviewer3+"\"}";
//
//          return s;
//      }
//构造评委状态字符串
    private String conditionSuccessJson(int reviewer, int status) {

        String s = "{ \"code\": \"cond\" , \"reviewer\": \"" + reviewer + "\", \"status\": \"" + status + "\"}";

        return s;
    }

    //构造学生信息字符串
    private String infoSuccessJson(int serialNumber, String examNumber, String dominantTerm, String secondaryTerm, String sightsinging) {

        String s = "{ \"code\": \"info\" ,  \"serialNumber\": \"" + serialNumber + "\", \"examNumber\": \"" + examNumber + "\",\"dominantTerm\": \"" + dominantTerm + "\",\"secondaryTerm\": \"" + secondaryTerm + "\",\"sightsinging\": \"" + sightsinging + "\"}";

        return s;
    }
    //构造失败字符串
    private String failJson(String reason) {

        String s = "{ \"code\": \"fail\" , \"reason\": \"" + reason + "\"}";
        return s;
    }


}
