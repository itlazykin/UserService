package ru.astondevs.users.input;

public interface Input {
    String askStr(String prompt);

    int askInt(String prompt);

    long askLong(String prompt);
}
