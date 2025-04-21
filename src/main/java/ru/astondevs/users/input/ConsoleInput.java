package ru.astondevs.users.input;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String askStr(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(askStr(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Введите число!");
            }
        }
    }

    @Override
    public long askLong(String prompt) {
        while (true) {
            try {
                return Long.parseLong(askStr(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Введите число!");
            }
        }
    }
}
