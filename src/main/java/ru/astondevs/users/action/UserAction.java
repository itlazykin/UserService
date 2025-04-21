package ru.astondevs.users.action;

import ru.astondevs.users.configuration.output.Output;
import ru.astondevs.users.dao.SimpleUserDao;
import ru.astondevs.users.input.Input;

public interface UserAction {
    String name();

    boolean execute(Input input, SimpleUserDao dao, Output out);
}
