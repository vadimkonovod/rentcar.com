package by.bsu.command.impl;

import by.bsu.command.Command;
import by.bsu.controller.JspPageName;
import by.bsu.exception.service.CarServiceException;
import by.bsu.exception.service.OrderServiceException;
import by.bsu.service.impl.CarServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;

public class SearchCarsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String page = null;

        String city = request.getParameter(LOCATION_CITY_ATTR_NAME);
        Date startDate = Date.valueOf(request.getParameter(START_DATE_ATTR_NAME));
        Date finishDate = Date.valueOf(request.getParameter(FINISH_DATE_ATTR_NAME));

        session.setAttribute(ST_DATE_ATTR_NAME, startDate);
        session.setAttribute(FIN_DATE_ATTR_NAME, finishDate);

        try {
            request.setAttribute(CARLIST_ATTR_NAME, CarServiceImpl.getInstance().searchCars(city, startDate.getTime(), finishDate.getTime()));
            page = JspPageName.DISPLAY_PAGE;
        } catch (CarServiceException | OrderServiceException e) {
            page = JspPageName.ERROR_PAGE;
        }

        return page;
    }
}

