package test.push;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

public class MyWebHandler extends AbstractWebSocketHandler {
    private final String TAG = "MyWebHandler";
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println(TAG+"收到了信息："+message.getPayload());
        session.sendMessage(new TextMessage("I have receive your message!"));
    }
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println(TAG+"建立了连接");
    }
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println(TAG+"关闭了连接 status: "+status);
    }
}
