package test.configuration;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import test.interceptors.MyInterceptor;
import test.interceptors.MyTestInterceptor;
import test.interceptors.WebSocketHandshakeInterceptor;
import test.push.MyWebHandler;

@Configuration
@EnableWebSocket
public class MyWebAppConfiguration extends WebMvcConfigurerAdapter implements WebSocketConfigurer{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns(new String[]{"/","/login","/validate","/resultQuery","/query"});
        registry.addInterceptor(new MyTestInterceptor()).addPathPatterns("/student/dotest");
        super.addInterceptors(registry);
    }
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(myHandler(),"/myHandler").addInterceptors(new WebSocketHandshakeInterceptor());
    }
    @Bean
    public WebSocketHandler myHandler() {
        return new MyWebHandler();
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
