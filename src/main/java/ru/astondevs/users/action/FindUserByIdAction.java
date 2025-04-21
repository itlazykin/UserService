package ru.astondevs.users.action;

import ru.astondevs.users.configuration.output.Output;
import ru.astondevs.users.dao.SimpleUserDao;
import ru.astondevs.users.input.Input;
import ru.astondevs.users.model.User;

public class FindUserByIdAction implements UserAction {
    @Override
    public String name() {
        return "Найти пользователя по ID";
    }

    @Override
    public boolean execute(Input input, SimpleUserDao dao, Output out) {
        out.println("\n=== Поиск пользователя по ID ===");
        long id = input.askLong("Введите ID пользователя: ");
        User user = dao.findById(id);
        if (user != null) {
            out.println("Найден пользователь: " + user);
        } else {
            out.println("Пользователь с ID " + id + " не найден");
        }
        return true;
    }
}
