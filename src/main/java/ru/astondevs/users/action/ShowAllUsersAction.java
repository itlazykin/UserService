package ru.astondevs.users.action;

import ru.astondevs.users.configuration.output.Output;
import ru.astondevs.users.dao.SimpleUserDao;
import ru.astondevs.users.input.Input;
import ru.astondevs.users.model.User;

import java.util.List;

public class ShowAllUsersAction implements UserAction {
    @Override
    public String name() {
        return "Показать всех пользователей";
    }

    @Override
    public boolean execute(Input input, SimpleUserDao dao, Output out) {
        out.println("\n=== Список всех пользователей ===");
        List<User> users = dao.findAll();
        if (users.isEmpty()) {
            out.println("Пользователи не найдены");
        } else {
            users.forEach(user -> out.println(user.toString()));
        }
        return true;
    }
}
