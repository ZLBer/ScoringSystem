package test.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.Arrays;
import java.util.Map;

@WebListener()
public class MyListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener,ServletRequestListener {

    // Public constructor is required by servlet spec
    public MyListener() {
        System.out.println("MyListener : MyListener is created");
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        System.out.println("MyListener : context is init");
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
        System.out.println("MyListener : session is destroyed");
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("MyListener : session is created");
      /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
        System.out.println("MyListener : session is destroyed");
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
        System.out.println("MyListener : something has been (added) in session | varName : "+sbe.getName()+" | varValue : "+sbe.getValue());
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
        System.out.println("MyListener : something has been (removed) from session | varName : "+sbe.getName()+" | varValue : "+sbe.getValue());
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
        System.out.println("MyListener : something has been (replaced) from session | varName : "+sbe.getName()+" | varValue : "+sbe.getValue());
    }


    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        /*
        This method is invoked when a request is destroyed.
         */
        System.out.println("MyListener : request destroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        /*
        This method is invoked when a request is initialized.
         */
        System.out.println("MyListener : request init ");
        Map<String,String[]> m = servletRequestEvent.getServletRequest().getParameterMap();
        for (String a : m.keySet()){
            System.out.println("------paramName : "+a+"   paramValue : "+ Arrays.toString(m.get(a)));
        }
    }
}
