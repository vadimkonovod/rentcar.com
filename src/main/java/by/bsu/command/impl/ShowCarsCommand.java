package by.bsu.command.impl;

import by.bsu.command.Command;
import by.bsu.controller.JspPageName;
import by.bsu.exception.service.CarServiceException;
import by.bsu.model.Car;
import by.bsu.service.impl.CarServiceImpl;
import by.bsu.util.SubListDisplayUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowCarsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String page = null;

        List<Car> carList = null;
        try {
            carList = CarServiceImpl.getInstance().getCars();
            request.setAttribute(LIST_SIZE_ATTR_NAME, carList.size());
            int pageNumber = Integer.parseInt(request.getParameter(PAGE_NUMBER_ATTR_NAME));

            List<Car> targetPageCarList = SubListDisplayUtil.getInstance().extractCarsFromCollection(pageNumber, carList);
            request.setAttribute(CARLIST_ATTR_NAME, targetPageCarList);

            page = JspPageName.ALL_CARS;
        } catch (CarServiceException e) {
            page = JspPageName.ERROR_PAGE;
        }

        return page;
    }
}
