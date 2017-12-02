package test.interceptors;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import test.GlobalVariance;
import test.domain.Login;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by libin on 2017/11/25.
 */
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object
            > attributes) throws Exception {
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession();
            Login login = (Login) session.getAttribute("user");
            arrangeSeats(login.getAccount());
            System.out.println("》》》》》》》》》》》》》握手之前  评委："+login.getAccount());
        }

        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
    }

    private static void arrangeSeats(String account) {
        if (account.equals(GlobalVariance.ACCOUNT_GUARD_A)) {
            GlobalVariance.SEAT = 0;

        } else if (account.equals(GlobalVariance.ACCOUNT_GUARD_B)) {
            GlobalVariance.SEAT = 10;

        } else if (account.equals(GlobalVariance.ACCOUNT_REVIEWE_A1)) {
            GlobalVariance.SEAT = 1;

        } else if (account.equals(GlobalVariance.ACCOUNT_REVIEWE_A2)) {
            GlobalVariance.SEAT = 2;

        } else if (account.equals(GlobalVariance.ACCOUNT_REVIEWE_A3)) {
            GlobalVariance.SEAT = 3;

        } else if (account.equals(GlobalVariance.ACCOUNT_REVIEWE_B1)) {
            GlobalVariance.SEAT = 11;

        } else if (account.equals(GlobalVariance.ACCOUNT_REVIEWE_B2)) {
            GlobalVariance.SEAT = 12;

        } else if (account.equals(GlobalVariance.ACCOUNT_REVIEWE_B3)) {
            GlobalVariance.SEAT = 13;

        }
    }
}
