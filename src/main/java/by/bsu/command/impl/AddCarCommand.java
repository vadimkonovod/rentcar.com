package by.bsu.command.impl;

import by.bsu.command.Command;
import by.bsu.controller.JspPageName;
import by.bsu.exception.service.CarServiceException;
import by.bsu.service.impl.CarServiceImpl;
import by.bsu.util.MessagesPropertiesUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddCarCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String page = null;

        String brand = request.getParameter(CAR_BRAND_ATTR_NAME);
        String model = request.getParameter(CAR_MODEL_ATTR_NAME);
        String year = request.getParameter(CAR_YEAR_ATTR_NAME);
        String city = request.getParameter(CAR_CITY_ATTR_NAME);

        try {
            CarServiceImpl.getInstance().addCar(brand, model, year, city);
            request.setAttribute(CARLIST_ATTR_NAME, CarServiceImpl.getInstance().getCars());
            page = JspPageName.ADD_CAR_CONGRATS;
        } catch (NumberFormatException e) {
            request.setAttribute(YEAR_NOT_VALID_MESSAGE_ATTR_NAME, MessagesPropertiesUtil.getInstance().getPropByName(YEAR_NOT_VALID_ATTR_NAME));
            page = JspPageName.ADD_CAR;
        } catch (CarServiceException e) {
            page = JspPageName.ERROR_PAGE;
        }
        return page;
    }
}
