package by.bsu.command.impl;

import by.bsu.command.Command;
import by.bsu.controller.JspPageName;
import by.bsu.exception.service.AccountServiceException;
import by.bsu.exception.IllegalEmailValidationException;
import by.bsu.model.Account;
import by.bsu.service.impl.AccountServiceImpl;
import by.bsu.util.MessagesPropertiesUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeEmailCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String page = null;

        String newEmail = request.getParameter(NEW_EMAIL_ATTR_NAME);
        Account a = (Account) session.getAttribute(ACCOUNT_ATTR_NAME);

        try {
            AccountServiceImpl.getInstance().updateEmail(a.getId(), newEmail);
            session.setAttribute(ACCOUNT_ATTR_NAME, AccountServiceImpl.getInstance().getAccountById(a.getId()));
            request.setAttribute(SUCCESS_EMAIL_CHANGE_MESSAGE_ATTR_NAME, MessagesPropertiesUtil.getInstance().getPropByName(SUCCESS_EMAIL_CHANGE_ATTR_NAME));
            page = JspPageName.MY_INFO;
        } catch (IllegalEmailValidationException e) {
            request.setAttribute(EMAIL_CHANGE_ERROR_MESSAGE_ATTR_NAME, MessagesPropertiesUtil.getInstance().getPropByName(EMAIL_CHANGE_ERROR_ATTR_NAME));
            page = JspPageName.CHANGE_EMAIL;
        } catch (AccountServiceException e) {
            page = JspPageName.ERROR_PAGE;
        }
        return page;
    }

}