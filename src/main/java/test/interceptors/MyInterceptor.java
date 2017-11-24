package test.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("MyInterceptor : >>>>>>>>>>>>>>>>>>>>>>>>>preHandle<<<<<<<<<<<<<<<<<<<<<<");
        if (httpServletRequest.getSession().getAttribute("user")==null){
            System.out.println("登录验证失败");
            httpServletResponse.sendRedirect("/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor : >>>>>>>>>>>>>>>>>>>>>>>>>postHandle<<<<<<<<<<<<<<<<<<<<<<");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("MyInterceptor : >>>>>>>>>>>>>>>>>>>>>>>>>afterComplete<<<<<<<<<<<<<<<<<<<<<<");
    }
}
