package by.bsu.command.impl;

import by.bsu.command.Command;
import by.bsu.controller.JspPageName;
import by.bsu.exception.service.CarServiceException;
import by.bsu.model.Car;
import by.bsu.service.impl.CarServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PreOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String page = null;

        int carId = Integer.parseInt(request.getParameter(CAR_ID_ATTR_NAME));
        try {
            Car c = CarServiceImpl.getInstance().getCarById(carId);
            session.setAttribute(CAR_ATTR_NAME, c);
            page = JspPageName.PRE_ORDER_PAGE;
        } catch (CarServiceException e) {
            page = JspPageName.ERROR_PAGE;
        }
        return page;
    }
}
