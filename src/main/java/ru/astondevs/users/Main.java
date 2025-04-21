package ru.astondevs.users;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.astondevs.users.action.*;
import ru.astondevs.users.configuration.HibernateConfig;
import ru.astondevs.users.dao.SimpleUserDao;
import ru.astondevs.users.input.ConsoleInput;
import ru.astondevs.users.input.Input;
import ru.astondevs.users.output.ConsoleOutput;
import ru.astondevs.users.output.Output;


import java.util.Arrays;
import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private final Output out;

    public Main(Output out) {
        this.out = out;
    }

    public void init(Input input, SimpleUserDao dao, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Выберите пункт: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Неверный ввод, выберите: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, dao, out);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("\n=== Меню управления пользователями ===");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + ". " + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        try {
            LOGGER.info("Приложение запущено");
            Output output = new ConsoleOutput();
            Input input =  new ConsoleInput();
            SimpleUserDao dao = new SimpleUserDao();
            List<UserAction> actions = Arrays.asList(
                    new CreateUserAction(),
                    new FindUserByIdAction(),
                    new ShowAllUsersAction(),
                    new UpdateUserAction(),
                    new DeleteUserAction(),
                    new ExitAction()
            );
            new Main(output).init(input, dao, actions);
        } catch (Exception e) {
            LOGGER.error("Ошибка в приложении", e);
            System.err.println("Ошибка: " + e.getMessage());
        } finally {
            HibernateConfig.shutdown();
            LOGGER.info("Приложение остановлено");
        }
    }
}
