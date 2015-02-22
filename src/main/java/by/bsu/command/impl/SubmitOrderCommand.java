package by.bsu.command.impl;

import by.bsu.command.Command;
import by.bsu.controller.JspPageName;
import by.bsu.exception.service.OrderServiceException;
import by.bsu.model.Account;
import by.bsu.model.Car;
import by.bsu.model.Order;
import by.bsu.service.impl.OrderServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;

public class SubmitOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String page = null;

        Account a = (Account) session.getAttribute(ACCOUNT_ATTR_NAME);
        Car c = (Car) session.getAttribute(CAR_ATTR_NAME);
        Date start = (Date) session.getAttribute(ST_DATE_ATTR_NAME);
        Date finish = (Date) session.getAttribute(FIN_DATE_ATTR_NAME);

        Order o = new Order(a.getId(), c.getId(), start, finish);
        try {
            OrderServiceImpl.getInstance().addOrder(o);
            page = JspPageName.SUBMIT_ORDER_PAGE;
        } catch (OrderServiceException e) {
            page = JspPageName.ERROR_PAGE;
        }

        return page;
    }
}
