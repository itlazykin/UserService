package ru.astondevs.users.input;

public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    @Override
    public String askStr(String prompt) {
        return input.askStr(prompt);
    }

    @Override
    public int askInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(input.askStr(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное число!");
            }
        }
    }

    @Override
    public long askLong(String prompt) {
        while (true) {
            try {
                return Long.parseLong(input.askStr(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное число!");
            }
        }
    }
}
