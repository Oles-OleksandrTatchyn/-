package commands;

import java.util.Scanner;

public class ExitCommand implements Command {
  private Scanner scanner;

  public ExitCommand(Scanner scanner) {
    this.scanner = scanner;
  }

  @Override
  public void execute() {
    System.out.println("Goodbye!");
    scanner.close();
    System.exit(0);
  }
}