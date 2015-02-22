package by.bsu.command.impl;

import by.bsu.command.Command;
import by.bsu.controller.JspPageName;
import by.bsu.exception.service.AccountServiceException;
import by.bsu.exception.IllegalEmailValidationException;
import by.bsu.exception.IllegalPasswordValidationException;
import by.bsu.service.impl.AccountServiceImpl;
import by.bsu.util.MessagesPropertiesUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class RegisterAccCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String page = null;

        String name = request.getParameter(NAME_ATTR_NAME);
        String surnname = request.getParameter(SURNAME_ATTR_NAME);
        String age = request.getParameter(AGE_ATTR_NAME);
        String email = request.getParameter(EMAIL_ATTR_NAME);
        String login = request.getParameter(LOGIN_ATTR_NAME);
        String password = request.getParameter(PASSWORD_ATTR_NAME);
        String verpassword = request.getParameter(VERIFY_PASS_ATTR_NAME);

        try {
            AccountServiceImpl.getInstance().regAccount(name, surnname, age, email, login, password, verpassword);
            session.setAttribute(ACCOUNT_ATTR_NAME, AccountServiceImpl.getInstance().getAccountByLogin(login));
            page = JspPageName.MAIN_PAGE;
        } catch (IllegalEmailValidationException e) {
            request.setAttribute(EMAIL_CHANGE_ERROR_MESSAGE_ATTR_NAME, MessagesPropertiesUtil.getInstance().getPropByName(EMAIL_CHANGE_ERROR_ATTR_NAME));
            page = JspPageName.REGISTER_PAGE;
        } catch (IllegalPasswordValidationException e) {
            request.setAttribute(PASSWORD_ERROR_MESSAGE_ATTR_NAME, MessagesPropertiesUtil.getInstance().getPropByName(PASSWORD_ERROR_ATTR_NAME));
            page = JspPageName.REGISTER_PAGE;
        } catch (SQLException e) {
            request.setAttribute(REGISTER_ERROR_MESSAGE_ATTR_NAME, MessagesPropertiesUtil.getInstance().getPropByName(REGISTER_ERROR_ATTR_NAME));
            page = JspPageName.REGISTER_PAGE;
        } catch (AccountServiceException e) {
            page = JspPageName.ERROR_PAGE;
        }
        return page;
    }
}
