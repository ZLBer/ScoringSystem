package test.interceptors;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 匹配方式
 * 0 精准
 * 1 模糊
 * 2 大于
 * 3 小于
 * 4 之间
 */
public class MyTestInterceptor implements HandlerInterceptor {
    private final String TAG = "MyTestInterceptor";

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println(TAG + " : >>>>>>>>>>>>>>>>>>>>>>>>>preHandle<<<<<<<<<<<<<<<<<<<<<<");

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println(TAG + " : >>>>>>>>>>>>>>>>>>>>>>>>>postHandle<<<<<<<<<<<<<<<<<<<<<<");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println(TAG + " : >>>>>>>>>>>>>>>>>>>>>>>>>afterComplete<<<<<<<<<<<<<<<<<<<<<<");
    }

}