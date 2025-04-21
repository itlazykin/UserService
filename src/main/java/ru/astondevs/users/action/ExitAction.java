package ru.astondevs.users.action;

import ru.astondevs.users.configuration.output.Output;
import ru.astondevs.users.dao.SimpleUserDao;
import ru.astondevs.users.input.Input;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "Выход";
    }

    @Override
    public boolean execute(Input input, SimpleUserDao dao, Output out) {
        out.println("=== Завершение работы приложения ===");
        if (input.askStr("Вы уверены? (y/n): ").equalsIgnoreCase("y")) {
            out.println("Работа приложения завершена");
            return false;
        }
        return true;
    }
}
