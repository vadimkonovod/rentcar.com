package by.bsu.command.impl;

import by.bsu.command.Command;
import by.bsu.controller.JspPageName;
import by.bsu.exception.service.AccountServiceException;
import by.bsu.service.impl.AccountServiceImpl;
import by.bsu.util.MessagesPropertiesUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        String page = null;
        String login = request.getParameter(LOGIN_ATTR_NAME);
        String pass = request.getParameter(PASSWORD_ATTR_NAME);

        try {
            if (AccountServiceImpl.getInstance().checkLogin(login, pass)){
                session.setAttribute(ACCOUNT_ATTR_NAME, AccountServiceImpl.getInstance().getAccountByLogin(login));
                page = JspPageName.MAIN_PAGE;
            } else {
                request.setAttribute(LOGIN_ERROR_MESSAGE_ATTR_NAME, MessagesPropertiesUtil.getInstance().getPropByName(LOGIN_ERROR_ATTR_NAME));
                page = JspPageName.INDEX_PAGE;
            }
        } catch (AccountServiceException e) {
            page = JspPageName.ERROR_PAGE;
        }
        return page;
    }
}
