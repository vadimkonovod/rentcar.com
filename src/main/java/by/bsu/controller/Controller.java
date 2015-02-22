package by.bsu.controller;

import by.bsu.command.Command;
import by.bsu.command.CommandHelper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
    public Controller() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            processRequest(request, response); //test develop
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String commandName = request.getParameter(RequestParameterName.COMMAND_NAME);
        Command command = CommandHelper.getInstance().getCommand(commandName);

        String page = command.execute(request, response);

        if(page != null) {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
