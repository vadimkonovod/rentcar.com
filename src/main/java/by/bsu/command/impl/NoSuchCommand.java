package by.bsu.command.impl;

import by.bsu.command.Command;
import by.bsu.controller.JspPageName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoSuchCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return JspPageName.ERROR_PAGE;
    }
}
