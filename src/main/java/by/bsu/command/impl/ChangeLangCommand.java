package by.bsu.command.impl;

import by.bsu.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeLangCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession(true).setAttribute("local", request.getParameter("local"));
        return null;
    }
}
