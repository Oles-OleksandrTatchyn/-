//import commands.*;
//import salad.Salad;
//
//import java.util.Scanner;
//import java.util.InputMismatchException;
//import java.util.List;
//import java.util.ArrayList;
//
//public class ChefApp {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Salad salad = new Salad();
//
//        List<Command> commands = new ArrayList<>();
//        commands.add(new LoadIngredientsFromFileCommand(scanner, salad));
//        commands.add(new AddIngredientCommand(scanner, salad));
//        commands.add(new CalculateCaloriesCommand(salad));
//        commands.add(new SortIngredientsCommand(scanner, salad));
//        commands.add(new FindIngredientsCommand(scanner, salad));
//        commands.add(new ExitCommand(scanner));
//
//        while (true) {
//            System.out.println("\nChoose an action:");
//            System.out.println("1. Load existing ingredients from the file");
//            System.out.println("2. Add an ingredient to the salad");
//            System.out.println("3. Calculate the salad's calorie content");
//            System.out.println("4. Sort ingredients");
//            System.out.println("5. Find ingredients within a calorie range");
//            System.out.println("6. Exit\n");
//
//            int choice = getUserChoice(scanner);
//
//            if (choice >= 1 && choice <= commands.size()) {
//                commands.get(choice - 1).execute();
//            } else {
//                System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//
//    private static int getUserChoice(Scanner scanner) {
//        try {
//            return scanner.nextInt();
//        } catch (InputMismatchException e) {
//            scanner.nextLine();
//            return -1;
//        }
//    }
//}
import commands.*;
import logger.EmailSender;
import salad.Salad;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChefApp {
    private static final Logger logger = Logger.getLogger(ChefApp.class.getName());
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Додаємо обробник консольного логування
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
//        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);

        Salad salad = new Salad();
        List<Command> commands = new ArrayList<>();
        commands.add(new LoadIngredientsFromFileCommand(scanner, salad));
        commands.add(new AddIngredientCommand(scanner, salad));
        commands.add(new CalculateCaloriesCommand(salad));
        commands.add(new SortIngredientsCommand(scanner, salad));
        commands.add(new FindIngredientsCommand(scanner, salad));
        commands.add(new ExitCommand(scanner));

        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Load existing ingredients from the file");
            System.out.println("2. Add an ingredient to the salad");
            System.out.println("3. Calculate the salad's calorie content");
            System.out.println("4. Sort ingredients");
            System.out.println("5. Find ingredients within a calorie range");
            System.out.println("6. Exit\n");

            int choice = getUserChoice(scanner);

            if (choice >= 1 && choice <= commands.size()) {
                logger.info("User selected action: " + choice);

                try {
                    commands.get(choice - 1).execute();
                } catch (Exception e) {
                    logger.log(Level.SEVERE, "Critical error during command execution", e);

                    EmailSender.sendCriticalErrorEmail("Critical Error in ChefApp", e.getMessage());
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static int getUserChoice(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }
}
