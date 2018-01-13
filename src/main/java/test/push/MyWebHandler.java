package test.push;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;
import test.GlobalVariance;
import test.domain.Information;
import test.domain.InformationExample;
import test.domain.Score;
import test.domain.ScoreExample;
import test.mapper.InformationMapper;
import test.mapper.ScoreMapper;
import test.service.IGuardService;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MyWebHandler extends AbstractWebSocketHandler {
    private static Logger logger = Logger.getLogger(MyWebHandler.class);
    @Resource
    InformationMapper informationMapper;
    @Resource
    ScoreMapper scoreMapper;
    @Resource
    IGuardService guardService;

    private final String TAG = "WebSocketHandler";

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String receivedMessage = message.getPayload();
        if ("guardQuery".equals(receivedMessage.substring(0, 10))) {
            guardQueryInfo(session, receivedMessage.substring(10, receivedMessage.length()));
        } else if ("guardSubmit".equals(receivedMessage.substring(0, 11))) {
            submitToReviewerNotice(session, receivedMessage.substring(11, receivedMessage.length()));
        } else if ("reviewerSubmit".equals(receivedMessage.substring(0, 14))) {
            scoreNotice(session);
            try {
               finishExamingNotice(Integer.parseInt(receivedMessage.substring(14, receivedMessage.length())), session);
            }catch (Exception e){
                logger.error("完成打分通知出现错误"+e.getStackTrace());
            }
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println(TAG + "建立了连接 " + session.getId());
        GlobalVariance.SSessions[GlobalVariance.SEAT / 10][GlobalVariance.SEAT % 10] = session;
        //首先上线通知
        onLineNotice(session);
        //继而查询自己是否已经给现在在考场上的学生所打分
        onLineIsScore(session);
        //上线后需查询其他人的在线状态
        onLineFirstNotice(session);

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.info("连接" + session.getId() + "关闭了 status: " + status);
        offLineNotice(session);

    }

    //广播消息，实现对指定room内的多有角色进行通知
    private void broadcast(String room, String message) throws Exception {
        if ("A".equals(room)) {
            WebSocketSession[] AsocketSession = GlobalVariance.SSessions[0];
            for (WebSocketSession socketSession : AsocketSession) {
                if (socketSession != null)
                    socketSession.sendMessage(new TextMessage(message));
            }
        } else if ("B".equals(room)) {
            WebSocketSession[] AsocketSession = GlobalVariance.SSessions[1];
            for (WebSocketSession socketSession : AsocketSession) {
                if (socketSession != null)
                    socketSession.sendMessage(new TextMessage(message));
            }
        }
    }

    //下线通知
    private void offLineNotice(WebSocketSession session) throws Exception {
        logger.info(session.getId()+"下线通知");
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

    //查询是否给现在在考试的人打分
    private void onLineIsScore(WebSocketSession session) throws Exception {
        logger.info(session.getId()+"上线后查询是否给当前学生打分");
        List<Score> scores = null;
//        scores=  scoreMapper.selectBySerialNumberANDReviewer(GlobalVariance.SERIALNUMBER_EXAMING_A,getReviewerAccout(2,"A"));
//for(Score scores1:scores){
//    System.out.println(scores1.getReviewer());
//}

        for (int i = 1; i < 4; i++) {
            if (GlobalVariance.SSessions[0][i] == null) continue;
            if (session.getId() == GlobalVariance.SSessions[0][i].getId()) {
                if (GlobalVariance.SERIALNUMBER_EXAMING_A > -1) {
                    System.out.println(GlobalVariance.SERIALNUMBER_EXAMING_A + "          " + getReviewerAccout(i, "A"));
                    scores = scoreMapper.selectBySerialNumberANDReviewer(GlobalVariance.SERIALNUMBER_EXAMING_A, getReviewerAccout(i, "A"));
                    if (scores.size() > 0) broadcast("A", conditionSuccessJson(i, GlobalVariance.REVIEWER_SCORE));
                    System.out.println(scores.size());
                }



                return;
            }

        }
        for (int i = 1; i < 4; i++) {

            if (GlobalVariance.SSessions[1][i] == null) continue;
            if (session.getId() == GlobalVariance.SSessions[1][i].getId()) {
                if (GlobalVariance.SERIALNUMBER_EXAMING_B > -1){
                    scores = scoreMapper.selectBySerialNumberANDReviewer(GlobalVariance.SERIALNUMBER_EXAMING_B, getReviewerAccout(i, "B"));
                    if(scores.size()>0)   broadcast("B",conditionSuccessJson(i,GlobalVariance.REVIEWER_SCORE));
                }

            }
        }
    }

    //上线后首先查询其他人的状态
    private void onLineFirstNotice(WebSocketSession session) throws Exception {
        logger.info(session.getId()+"上线后首先查询其他人的状态");
        int place = checkReviewerORGuardPlace(session);
        int status[][] = new int[2][4];

        if (place == GlobalVariance.PLACE_A && GlobalVariance.SERIALNUMBER_EXAMING_A > 0) {
            List<Score> scores = scoreMapper.selectBySerialNumberANDPlace(place, GlobalVariance.SERIALNUMBER_EXAMING_A);
            for (Score score : scores) {
                if (score.getReviewer().equals(GlobalVariance.ACCOUNT_REVIEWE_A1))
                    status[0][1] = GlobalVariance.REVIEWER_SCORE;
                else if (score.getReviewer().equals(GlobalVariance.ACCOUNT_REVIEWE_A2))
                    status[0][2] = GlobalVariance.REVIEWER_SCORE;
                else if (score.getReviewer().equals(GlobalVariance.ACCOUNT_REVIEWE_A3))
                    status[0][3] = GlobalVariance.REVIEWER_SCORE;
            }
        } else if (place == GlobalVariance.PLACE_B && GlobalVariance.SERIALNUMBER_EXAMING_B > 0) {
            List<Score> scores = scoreMapper.selectBySerialNumberANDPlace(place, GlobalVariance.SERIALNUMBER_EXAMING_B);
            for (Score score : scores) {
                if (score.getReviewer().equals(GlobalVariance.ACCOUNT_REVIEWE_B1))
                    status[1][1] = GlobalVariance.REVIEWER_SCORE;
                else if (score.getReviewer().equals(GlobalVariance.ACCOUNT_REVIEWE_B2))
                    status[1][2] = GlobalVariance.REVIEWER_SCORE;
                else if (score.getReviewer().equals(GlobalVariance.ACCOUNT_REVIEWE_B3))
                    status[1][3] = GlobalVariance.REVIEWER_SCORE;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (GlobalVariance.SSessions[0][i] == null) continue;
            if (session.getId() == GlobalVariance.SSessions[0][i].getId()) {
                for (int j = 1; j < 4; j++) {
                    if (GlobalVariance.SSessions[0][j] == null) continue;
                    else {
                        if (status[0][j] == GlobalVariance.REVIEWER_SCORE)
                            session.sendMessage(new TextMessage(conditionSuccessJson(j, GlobalVariance.REVIEWER_SCORE)));
                        else
                            session.sendMessage(new TextMessage(conditionSuccessJson(j, GlobalVariance.REVIEWER_ONLINE)));
                    }

                }
                return;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (GlobalVariance.SSessions[1][i] == null) continue;
            if (session.getId() == GlobalVariance.SSessions[1][i].getId()) {
                for (int j = 1; j < 4; j++) {
                    if (GlobalVariance.SSessions[1][j] != null) {
                        if (status[1][j] == GlobalVariance.REVIEWER_SCORE)
                            session.sendMessage(new TextMessage(conditionSuccessJson(j, GlobalVariance.REVIEWER_SCORE)));
                        else
                            session.sendMessage(new TextMessage(conditionSuccessJson(j, GlobalVariance.REVIEWER_ONLINE)));
                    }

                }
                return;
            }
        }
    }

    //上线通知
    private void onLineNotice(WebSocketSession session) throws Exception {
        logger.info(session.getId()+"上线后通知其他评委");
        for (int i = 0; i < 4; i++) {
            if (GlobalVariance.SSessions[0][i] == null) continue;
            if (session.getId() == GlobalVariance.SSessions[0][i].getId()) {
                broadcast("A", conditionSuccessJson(i, GlobalVariance.REVIEWER_ONLINE));
                return;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (session.equals(GlobalVariance.SSessions[1][i])) {
                broadcast("B", conditionSuccessJson(i, GlobalVariance.REVIEWER_ONLINE));
                return;
            }
        }
    }

    //提交评委通知
    private void submitToReviewerNotice(WebSocketSession session, String serialNumber) throws Exception {
        ScoreExample scoreExample = new ScoreExample();
        ScoreExample.Criteria criter = scoreExample.createCriteria();
        criter.andSerialNumberEqualTo(Integer.parseInt(serialNumber));

        //判断该学生是否已经考试
        if (checkRoomOfScoreList(scoreMapper.selectByExample(scoreExample), checkGuardPlace(session))) {
            session.sendMessage(new TextMessage(failJson("该序号的学生已经考试")));
            return;
        }
        if (checkGuardPlace(session) == GlobalVariance.PLACE_A && GlobalVariance.SERIALNUMBER_EXAMING_A != -1) {
            session.sendMessage(new TextMessage(failJson("A考场有考生正在考试")));
            return;
        } else if (checkGuardPlace(session) == GlobalVariance.PLACE_B && GlobalVariance.SERIALNUMBER_EXAMING_B != -1) {
            session.sendMessage(new TextMessage(failJson("B考场有考生正在考试")));
            return;
        }
        InformationExample example = new InformationExample();
        InformationExample.Criteria criteria = example.createCriteria();
        criteria.andSerialNumberEqualTo(Integer.valueOf(serialNumber));
        List<Information> informations = informationMapper.selectByExample(example);
        Information information = null;
        for (Information inf : informations) {
            if (GlobalVariance.SSessions[0][0] != null && session.getId() == GlobalVariance.SSessions[0][0].getId())
                if (inf.getPlace() == GlobalVariance.PLACE_A)
                    information = inf;
            if (GlobalVariance.SSessions[1][0] != null && session.getId() == GlobalVariance.SSessions[1][0].getId())
                if (inf.getPlace() == GlobalVariance.PLACE_B)
                    information = inf;
        }
        //查询是否抽号，以防websocket链接断开
        if (information == null) {
            session.sendMessage(new TextMessage(failJson("该序号暂未抽取")));
            return;
        }

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        information.setEntranceTime(df.parse(df.format(new Date())));
        informationMapper.updateByPrimaryKeySelective(information);
        String jsonStr = infoSuccessJson(information.getPlace(), information.getSerialNumber(), information.getExamNumber(), information.getDominantTerm(), information.getDominantInstrument(),information.getDominantSong(),information.getSecondaryTerm(),information.getSecondaryInstrument(),information.getSecondarySong(), information.getSightsinging());

        if (GlobalVariance.SSessions[0][0] != null && session.getId() == GlobalVariance.SSessions[0][0].getId()) {
            for (int i = 1; i < 4; i++)
                if (GlobalVariance.SSessions[0][i] != null) {
                    GlobalVariance.SSessions[0][i].sendMessage(new TextMessage(jsonStr));
                    broadcast("A", conditionSuccessJson(i, GlobalVariance.REVIEWER_ONLINE));
                }
            GlobalVariance.SERIALNUMBER_EXAMING_A = Integer.parseInt(serialNumber);

        } else if (GlobalVariance.SSessions[1][0] != null && session.getId() == GlobalVariance.SSessions[1][0].getId()) {
            for (int i = 1; i < 4; i++)
                if (GlobalVariance.SSessions[1][i] != null) {
                    GlobalVariance.SSessions[1][i].sendMessage(new TextMessage(jsonStr));
                    broadcast("B", conditionSuccessJson(i, GlobalVariance.REVIEWER_ONLINE));
                }
            GlobalVariance.SERIALNUMBER_EXAMING_B = Integer.parseInt(serialNumber);
        }
        //提示控制进场人进场成功
        session.sendMessage(new TextMessage(successJson("进场成功！", serialNumber)));
    }


    //评分通知
    private void scoreNotice(WebSocketSession session) throws Exception {
        logger.info(session.getId()+" 已完成对当前考生的评分");
        for (int i = 0; i < 4; i++) {
            if (GlobalVariance.SSessions[0][i] == null) continue;
            if (session.getId() == GlobalVariance.SSessions[0][i].getId()) {
                broadcast("A", conditionSuccessJson(i, GlobalVariance.REVIEWER_SCORE));
                return;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (GlobalVariance.SSessions[1][i] == null) continue;
            if (session.getId() == GlobalVariance.SSessions[1][i].getId()) {
                broadcast("B", conditionSuccessJson(i, GlobalVariance.REVIEWER_SCORE));
                return;
            }
        }
    }

    //该考生是否考试完毕
    private boolean cheakExamingStatus(int place, int serialNumber, WebSocketSession session) {
        ScoreExample scoreExample = new ScoreExample();
        ScoreExample.Criteria criteria = scoreExample.createCriteria();
        criteria.andSerialNumberEqualTo(serialNumber);
        List<Score> scores = scoreMapper.selectByExample(scoreExample);
        int count = 0;
        if (scores.size() < 1) return false;
        for (Score score : scores) {
            if (score.getPlace().equals(place)) count++;
        }
        if (count == 3){
            logger.info("所有评委均完成对"+place+"考场的"+serialNumber+"的打分");
            return true;
        }

        return false;
    }

    //考试完毕通知并置变量为-1
    private void finishExamingNotice(int serialNumber, WebSocketSession session) throws Exception {
        int place = checkReviewerPlace(session);
        if (cheakExamingStatus(place, serialNumber, session) == true) {

            if (place == GlobalVariance.PLACE_A) {
                GlobalVariance.SERIALNUMBER_EXAMING_A = -1;
                broadcast("A", finishJson("", serialNumber));
            } else if (place == GlobalVariance.PLACE_B) {
                GlobalVariance.SERIALNUMBER_EXAMING_B = -1;
                broadcast("B", finishJson("", serialNumber));
            }
        }
    }

    //进场控制人查询人员
    private void guardQueryInfo(WebSocketSession session, String serialNumber) throws Exception {
        //判断该学生是否抽号
        Information information = null;
        List<Information> informations = guardService.getInformationBySerialNumber(Integer.parseInt(serialNumber));
        if (informations.size() == 0) ;
        else
            information = checkRoomOfInformationList(informations, checkGuardPlace(session));


        if (information == null) {
            session.sendMessage(new TextMessage(failJson("该序号暂未抽取！")));
        } else {
            // TODO: 2018/1/2
            session.sendMessage(new TextMessage(infoSuccessJson(information.getPlace(), information.getSerialNumber(), information.getExamNumber(), information.getDominantTerm(),"","", information.getSecondaryTerm(), "","",information.getSightsinging())));
        }
    }
//判断评委或进场控制人属于个考场
private int checkReviewerORGuardPlace(WebSocketSession session) {
    for (int i = 0; i < 4; i++) {
        if (GlobalVariance.SSessions[0][i] != null && GlobalVariance.SSessions[0][i].getId() == session.getId()) {
            return GlobalVariance.PLACE_A;
        } else if (GlobalVariance.SSessions[1][i] != null && GlobalVariance.SSessions[1][i].getId() == session.getId()) {
            return GlobalVariance.PLACE_B;
        }
    }
    return -1;
}
    //判断该评委属于哪一个考场
    private int checkReviewerPlace(WebSocketSession session) {
        for (int i = 1; i < 4; i++) {
            if (GlobalVariance.SSessions[0][i] != null && GlobalVariance.SSessions[0][i].getId() == session.getId()) {
                return GlobalVariance.PLACE_A;
            } else if (GlobalVariance.SSessions[1][i] != null && GlobalVariance.SSessions[1][i].getId() == session.getId()) {
                return GlobalVariance.PLACE_B;
            }
        }
        return -1;
    }

    //判断该控制进场人属于哪一个考场
    private int checkGuardPlace(WebSocketSession session) {
        if (GlobalVariance.SSessions[0][0] != null && session.getId() == GlobalVariance.SSessions[0][0].getId())
            return GlobalVariance.PLACE_A;
        else
            return GlobalVariance.PLACE_B;
    }

    //判断scoreList里是否有指定考场学生
    private boolean checkRoomOfScoreList(List<Score> scores, int room) {
        if (scores.size() < 1) return false;
        for (Score score : scores) {
            if (score.getPlace().equals(room)) return true;
        }
        return false;
    }

    //判断InformationList里是否有指定考场学生,并返回该Information
    private Information checkRoomOfInformationList(List<Information> informations, int room) {
        if (informations.size() < 1) return null;
        for (Information information : informations) {
            if (information.getPlace().equals(room)) return information;
        }
        return null;
    }

    //根据序号获取reviewer的用户名
    private String getReviewerAccout(int reviewerNumber, String place) {
        String result = "";
        if ("A".equals(place)) {
            switch (reviewerNumber) {
                case 1: {
                    result = GlobalVariance.ACCOUNT_REVIEWE_A1;
                    break;
                }
                case 2: {
                    result = GlobalVariance.ACCOUNT_REVIEWE_A2;
                    break;
                }
                case 3: {
                    result = GlobalVariance.ACCOUNT_REVIEWE_A3;
                    break;
                }
            }
        } else if ("B".equals(place)) {
            switch (reviewerNumber) {
                case 1: {
                    result = GlobalVariance.ACCOUNT_REVIEWE_B1;
                    break;
                }
                case 2: {
                    result = GlobalVariance.ACCOUNT_REVIEWE_B2;
                    break;
                }
                case 3: {
                    result = GlobalVariance.ACCOUNT_REVIEWE_B3;
                    break;
                }
            }
        }
        return result;
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
    private String infoSuccessJson(int place, int serialNumber, String examNumber, String dominantTerm,String dominantInstrument,String dominantSong,  String secondaryTerm,String secondaryInstrument,String secondarySong, String sightsinging) {

        String s = "{ \"code\": \"info\" ,  \"serialNumber\": \"" + serialNumber + "\", \"examNumber\": \"" + examNumber + "\",\"dominantTerm\": \"" + dominantTerm + "\", \"dominantInstrument\": \"" + dominantInstrument +  "\", \"dominantSong\": \"" + dominantSong+ "\",\"secondaryTerm\": \"" + secondaryTerm + "\",\"secondaryInstrument\": \"" + secondaryInstrument +"\",\"secondarySong\": \"" + secondarySong +"\",\"sightsinging\": \"" + sightsinging + "\",\"place\": \"" + place + "\"}";

        return s;
    }

    //构造失败字符串
    private String failJson(String reason) {

        String s = "{ \"code\": \"fail\" , \"reason\": \"" + reason + "\"}";
        return s;
    }

    private String successJson(String reason, String serialNumber) {

        String s = "{ \"code\": \"success\" , \"reason\": \"" + reason + "\",\"serialNumber\":\"" + serialNumber + "\"}";
        return s;
    }

    private String finishJson(String reason, int serialNumber) {

        String s = "{ \"code\": \"finish\" , \"reason\": \"" + reason + "\",\"serialNumber\":\"" + serialNumber + "\"}";
        return s;
    }
}
