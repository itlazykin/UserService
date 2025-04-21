package ru.astondevs.users.output;

public class ConsoleOutput implements Output {
    @Override
    public void println(String message) {
        System.out.println(message);
    }
}
