package test.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = "/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String targetPath = ((HttpServletRequest)req).getServletPath();
        if (targetPath.equals("/login")) {
            chain.doFilter(req, resp);
        }else{
            System.out.println("LoginFilter : do login validation");
            chain.doFilter(req,resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {
    }

}
