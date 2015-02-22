package by.bsu.command;

import by.bsu.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandHelper {
    private static final CommandHelper instance = new CommandHelper();

    private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();

    public CommandHelper() {
        commands.put(CommandName.NO_SUCH_COMMAND, new NoSuchCommand());
        commands.put(CommandName.LOGIN, new LoginCommand());
        commands.put(CommandName.LOGOUT, new LogoutCommand());
        commands.put(CommandName.REGISTER_ACCOUNT, new RegisterAccCommand());
        commands.put(CommandName.PRE_ORDER, new PreOrderCommand());
        commands.put(CommandName.SUBMIT_ORDER, new SubmitOrderCommand());
        commands.put(CommandName.DELETE_ORDER, new DeleteOrderCommand());
        commands.put(CommandName.MYACCOUNT, new MyAccountCommand());
        commands.put(CommandName.SEARCH_CARS, new SearchCarsCommand());
        commands.put(CommandName.SHOW_CARS, new ShowCarsCommand());
        commands.put(CommandName.ADD_CAR, new AddCarCommand());
        commands.put(CommandName.DELETE_CAR, new DeleteCarCommand());
        commands.put(CommandName.SHOW_ACCOUNTS, new ShowAccountsCommand());
        commands.put(CommandName.SHOW_ORDERS, new ShowOrdersCommand());
        commands.put(CommandName.CHANGE_LANG, new ChangeLangCommand());
        commands.put(CommandName.CHANGE_EMAIL, new ChangeEmailCommand());
        commands.put(CommandName.CHANGE_PASS, new ChangePassCommand());
    }

    public static CommandHelper getInstance() {
        return instance;
    }

    public Command getCommand(String commandName) {
        CommandName name = null;
        try {
             name = CommandName.valueOf(commandName.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e){
            name = CommandName.NO_SUCH_COMMAND;
        }
        Command command;
        if (name != null) {
            command = commands.get(name);
        } else {
            command = commands.get(CommandName.NO_SUCH_COMMAND);
        }
        return command;
    }
}
