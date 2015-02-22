package by.bsu.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    public static final String LIST_SIZE_ATTR_NAME = "listSize";
    public static final String PAGE_NUMBER_ATTR_NAME = "index";
    public static final String CARLIST_ATTR_NAME = "cars";
    public static final String CAR_BRAND_ATTR_NAME = "brand";
    public static final String CAR_MODEL_ATTR_NAME = "model";
    public static final String CAR_YEAR_ATTR_NAME = "year";
    public static final String CAR_CITY_ATTR_NAME = "city";
    public static final String ORDERSLIST_ATTR_NAME = "orders";
    public static final String LOGIN_ATTR_NAME = "login";
    public static final String PASSWORD_ATTR_NAME = "password";
    public static final String ACCOUNT_ATTR_NAME = "account";
    public static final String NEW_EMAIL_ATTR_NAME = "newemail";
    public static final String OLD_PASS_ATTR_NAME = "oldpass";
    public static final String NEW_PASS_ATTR_NAME = "newpass";
    public static final String NEW_PASS_CONFIRM_ATTR_NAME = "newpasscon";
    public static final String ORDER_ID_ATTR_NAME = "orderID";
    public static final String CAR_ID_ATTR_NAME = "carID";
    public static final String CAR_ATTR_NAME = "car";
    public static final String NAME_ATTR_NAME = "name";
    public static final String SURNAME_ATTR_NAME = "surname";
    public static final String AGE_ATTR_NAME = "age";
    public static final String EMAIL_ATTR_NAME = "email";
    public static final String VERIFY_PASS_ATTR_NAME = "verpassword";
    public static final String LOCATION_CITY_ATTR_NAME = "locationCity";
    public static final String START_DATE_ATTR_NAME = "startDate";
    public static final String ST_DATE_ATTR_NAME = "stDate";
    public static final String FINISH_DATE_ATTR_NAME = "finishDate";
    public static final String FIN_DATE_ATTR_NAME = "finDate";
    public static final String ACCOUNTSLIST_ATTR_NAME = "accounts";
    public static final String ORDERS_CARS_LIST_ATTR_NAME = "ordersCars";

    public static final String YEAR_NOT_VALID_ATTR_NAME = "yearerror";
    public static final String YEAR_NOT_VALID_MESSAGE_ATTR_NAME = "yearNotValidMessage";
    public static final String SUCCESS_EMAIL_CHANGE_ATTR_NAME = "changeemail";
    public static final String SUCCESS_EMAIL_CHANGE_MESSAGE_ATTR_NAME = "successEmailChangeMessage";
    public static final String EMAIL_CHANGE_ERROR_ATTR_NAME = "emailerror";
    public static final String EMAIL_CHANGE_ERROR_MESSAGE_ATTR_NAME = "emailNotValidPassMessage";
    public static final String DELETE_CAR_ERROR_ATTR_NAME = "deletecarerror";
    public static final String DELETE_CAR_ERROR_MESSAGE_ATTR_NAME = "deleteCarNotValidMessage";
    public static final String LOGIN_ERROR_ATTR_NAME = "loginerror";
    public static final String LOGIN_ERROR_MESSAGE_ATTR_NAME = "errorLoginPassMessage";
    public static final String PASSWORD_ERROR_ATTR_NAME = "passworderror";
    public static final String PASSWORD_ERROR_MESSAGE_ATTR_NAME = "passwordNotValidPassMessage";
    public static final String REGISTER_ERROR_ATTR_NAME = "registererror";
    public static final String REGISTER_ERROR_MESSAGE_ATTR_NAME = "registerNotValidPassMessage";
    public static final String SUCCESS_PASS_CHANGE_ATTR_NAME = "changepass";
    public static final String SUCCESS_PASS_CHANGE_MESSAGE_ATTR_NAME = "successPassChangeMessage";
    public static final String OLD_PASS_NOT_VALID_ATTR_NAME = "oldpasserror";
    public static final String OLD_PASS_NOT_VALID_MESSAGE_ATTR_NAME = "oldPassNotValidMessage";


    public static final int START_PAGE_NUMBER = 1;

    public String execute(HttpServletRequest request, HttpServletResponse response);
}
