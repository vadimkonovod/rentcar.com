package by.bsu.command.impl;

import by.bsu.command.Command;
import by.bsu.controller.JspPageName;
import by.bsu.exception.service.OrderCarAccServiceException;
import by.bsu.model.OrderCarAcc;
import by.bsu.service.impl.OrderCarAccServiceImpl;
import by.bsu.util.SubListDisplayUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowOrdersCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String page = null;

        List<OrderCarAcc> ordersCarsList = null;
        try {
            ordersCarsList = OrderCarAccServiceImpl.getInstance().getAllOrders();
            request.setAttribute(LIST_SIZE_ATTR_NAME, ordersCarsList.size());
            int pageNumber = Integer.parseInt(request.getParameter(PAGE_NUMBER_ATTR_NAME));

            List<OrderCarAcc> targetPageCarList = SubListDisplayUtil.getInstance().extractCarsFromCollection(pageNumber, ordersCarsList);
            request.setAttribute(ORDERSLIST_ATTR_NAME, targetPageCarList);

            page = JspPageName.ALL_ORDERS;
        } catch (OrderCarAccServiceException e) {
            page = JspPageName.ERROR_PAGE;
        }

        return page;
    }
}
