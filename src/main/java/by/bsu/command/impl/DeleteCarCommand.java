package by.bsu.command.impl;

import by.bsu.command.Command;
import by.bsu.controller.JspPageName;
import by.bsu.exception.service.CarServiceException;
import by.bsu.model.Car;
import by.bsu.service.impl.CarServiceImpl;
import by.bsu.util.SubListDisplayUtil;
import by.bsu.util.MessagesPropertiesUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class DeleteCarCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String page = null;
        int id = Integer.parseInt(request.getParameter(CAR_ID_ATTR_NAME));

        try {
            CarServiceImpl.getInstance().deleteCar(id);
        } catch (CarServiceException e) {
            request.setAttribute(DELETE_CAR_ERROR_MESSAGE_ATTR_NAME, MessagesPropertiesUtil.getInstance().getPropByName(DELETE_CAR_ERROR_ATTR_NAME));
        }

        List<Car> carList = null;
        try {
            carList = CarServiceImpl.getInstance().getCars();
            request.setAttribute(LIST_SIZE_ATTR_NAME, carList.size());
            int pageNumber = START_PAGE_NUMBER;

            List<Car> targetPageCarList = SubListDisplayUtil.getInstance().extractCarsFromCollection(pageNumber, carList);
            request.setAttribute(CARLIST_ATTR_NAME, targetPageCarList);

            page = JspPageName.ALL_CARS;
        } catch (CarServiceException e) {
            page = JspPageName.ERROR_PAGE;
        }

        return page;
    }
}
