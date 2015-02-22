package by.bsu.command.impl;

import by.bsu.command.Command;
import by.bsu.controller.JspPageName;
import by.bsu.exception.service.AccountServiceException;
import by.bsu.service.impl.AccountServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowAccountsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String page = null;

        try {
            request.setAttribute(ACCOUNTSLIST_ATTR_NAME, AccountServiceImpl.getInstance().getAccounts());
            page = JspPageName.ALL_ACCOUNTS;
        } catch (AccountServiceException e) {
            page = JspPageName.ERROR_PAGE;
        }

        return page;
    }
}
