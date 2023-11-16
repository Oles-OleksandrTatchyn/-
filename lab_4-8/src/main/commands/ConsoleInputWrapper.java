package commands;

import java.util.Scanner;

public class ConsoleInputWrapper {
    private final Scanner scanner;

    public ConsoleInputWrapper(Scanner scanner) {
        this.scanner = scanner;
    }

    public int nextInt() {
        return scanner.nextInt();
    }

    public String nextLine() {
        return scanner.nextLine();
    }

}