package ru.astondevs.users.action;

import ru.astondevs.users.output.Output;
import ru.astondevs.users.repository.SimpleUserRepository;
import ru.astondevs.users.input.Input;

public interface UserAction {
    String name();

    boolean execute(Input input, SimpleUserRepository simpleUserRepository, Output out);
}
