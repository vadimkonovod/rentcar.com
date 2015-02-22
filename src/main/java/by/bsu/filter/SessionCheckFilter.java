package by.bsu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionCheckFilter implements Filter {
    private String contextPath;

    @Override
    public void init(FilterConfig fc) throws ServletException {
        contextPath = fc.getServletContext().getContextPath();
    }

    private boolean checkIfCommand(HttpServletRequest req, String command) {
        return req.getQueryString() != null && req.getQueryString().contains(command);
    }

    private boolean checkForAccess(HttpServletRequest req) {
        return checkIfCommand(req, "login") || checkIfCommand(req, "register_account")
                || checkIfCommand(req, "change_lang") || req.getServletPath().equals("/jsp/register.jsp");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (checkForAccess(req)) {
            fc.doFilter(request, response);
        } else if (req.getSession().getAttribute("account") == null) {
            res.sendRedirect(contextPath + "/index.jsp");
        } else {
            fc.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}