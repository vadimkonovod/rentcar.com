package by.bsu.command.impl;

import by.bsu.command.Command;
import by.bsu.controller.JspPageName;
import by.bsu.exception.service.OrderCarAccServiceException;
import by.bsu.exception.service.OrderServiceException;
import by.bsu.model.Account;
import by.bsu.service.impl.OrderCarAccServiceImpl;
import by.bsu.service.impl.OrderServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        String page = null;

        int id = Integer.parseInt(request.getParameter(ORDER_ID_ATTR_NAME));
        try {
            OrderServiceImpl.getInstance().deleteOrder(id);
            Account a = (Account) session.getAttribute(ACCOUNT_ATTR_NAME);
            request.setAttribute(ORDERS_CARS_LIST_ATTR_NAME, OrderCarAccServiceImpl.getInstance().getOrdersAndCarsByAccId(a.getId()));

            page = JspPageName.MY_ACCOUNT;
        } catch (OrderServiceException | OrderCarAccServiceException e) {
            page = JspPageName.ERROR_PAGE;
        }

        return page;
    }
}
