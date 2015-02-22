package by.bsu.command.impl;

import by.bsu.command.Command;
import by.bsu.controller.JspPageName;
import by.bsu.exception.service.AccountServiceException;
import by.bsu.exception.IllegalOldPasswordException;
import by.bsu.exception.IllegalPasswordValidationException;
import by.bsu.model.Account;
import by.bsu.service.impl.AccountServiceImpl;
import by.bsu.util.MessagesPropertiesUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangePassCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String page = null;

        String oldPass = request.getParameter(OLD_PASS_ATTR_NAME);
        String newPass = request.getParameter(NEW_PASS_ATTR_NAME);
        String newPassConfirm = request.getParameter(NEW_PASS_CONFIRM_ATTR_NAME);
        Account a = (Account) session.getAttribute(ACCOUNT_ATTR_NAME);

        try {
            AccountServiceImpl.getInstance().updatePassword(a.getId(), oldPass, newPass, newPassConfirm);
            session.setAttribute(ACCOUNT_ATTR_NAME, AccountServiceImpl.getInstance().getAccountById(a.getId()));
            request.setAttribute(SUCCESS_PASS_CHANGE_MESSAGE_ATTR_NAME, MessagesPropertiesUtil.getInstance().getPropByName(SUCCESS_PASS_CHANGE_ATTR_NAME));
            page = JspPageName.MY_INFO;
        } catch (IllegalOldPasswordException e) {
            request.setAttribute(OLD_PASS_NOT_VALID_MESSAGE_ATTR_NAME, MessagesPropertiesUtil.getInstance().getPropByName(OLD_PASS_NOT_VALID_ATTR_NAME));
            page = JspPageName.CHANGE_PASS;
        } catch (IllegalPasswordValidationException e) {
            request.setAttribute(PASSWORD_ERROR_MESSAGE_ATTR_NAME, MessagesPropertiesUtil.getInstance().getPropByName(PASSWORD_ERROR_ATTR_NAME));
            page = JspPageName.CHANGE_PASS;
        } catch (AccountServiceException e) {
            page = JspPageName.ERROR_PAGE;
        }
        return page;
    }
}
