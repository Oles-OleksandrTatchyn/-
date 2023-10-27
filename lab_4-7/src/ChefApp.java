import ingredients.*;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Comparator;

public class ChefApp {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Salad salad = new Salad();

    while (true) {
      System.out.println("\nChoose an action:");
      System.out.println("1. Add an ingredient to the salad");
      System.out.println("2. Calculate the salad's calorie content");
      System.out.println("3. Sort ingredients");
      System.out.println("4. Find ingredients within a calorie range");
      System.out.println("5. Exit\n");

      int choice = getUserChoice(scanner);

      switch (choice) {
        case 1:
          addIngredientToSalad(scanner, salad);
          break;
        case 2:
          calculateCaloriesOfSalad(salad);
          break;
        case 3:
          sortIngredientsMenu(scanner, salad);
          break;
        case 4:
          findIngredientsInCalorieRange(scanner, salad);
          break;
        case 5:
          System.out.println("Goodbye!");
          scanner.close();
          return;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  private static int getUserChoice(Scanner scanner) {
    try {
      return scanner.nextInt();
    } catch (InputMismatchException e) {
      // Clear the input buffer in case of invalid input
      scanner.nextLine();
      return -1;
    }
  }

  private static void addIngredientToSalad(Scanner scanner, Salad salad) {
    System.out.print("Enter the name of the ingredient: ");
    scanner.nextLine(); // Clear the buffer
    String name = scanner.nextLine();
    System.out.print("Enter the calorie content of the ingredient: ");
    int calories = getUserChoice(scanner);

    salad.addIngredient(new Ingredient(name, calories));
    System.out.println("Ingredient added to the salad.");
  }

  private static void calculateCaloriesOfSalad(Salad salad) {
    int totalCalories = salad.calculateCalories();
    System.out.println("Total calorie content of the salad: " + totalCalories + " kcal");
  }

  private static void sortIngredientsMenu(Scanner scanner, Salad salad) {
    System.out.println("\nChoose a sorting method:");
    System.out.println("1. By name");
    System.out.println("2. By calorie content");
  
    int sortChoice = getUserChoice(scanner);
  
    if (sortChoice == 1) {
      salad.sortIngredients(Comparator.comparing(Ingredient::getName));
      System.out.println("\nIngredients sorted by name:");
      printIngredients(salad);
    } else if (sortChoice == 2) {
      salad.sortIngredients(Comparator.comparing(Ingredient::getCalories));
      System.out.println("Ingredients sorted by calorie content:");
      printIngredients(salad);
    } else {
      System.out.println("Invalid choice for sorting.");
    }
  }
  
  private static void printIngredients(Salad salad) {
    List<Ingredient> ingredients = salad.getIngredients();
    for (Ingredient ingredient : ingredients) {
      System.out.println(ingredient.getName() + " - " + ingredient.getCalories() + " kcal");
    }
  }
  

  private static void findIngredientsInCalorieRange(Scanner scanner, Salad salad) {
    System.out.print("Enter the minimum calorie content: ");
    int minCalories = getUserChoice(scanner);
    System.out.print("Enter the maximum calorie content: ");
    int maxCalories = getUserChoice(scanner);

    List<Ingredient> result = salad.getIngredientsInCalorieRange(minCalories, maxCalories);

    System.out.println("Ingredients within the calorie range " + minCalories + " - " + maxCalories + " kcal:");
    for (Ingredient ingredient : result) {
      System.out.println(ingredient.getName() + " - " + ingredient.getCalories() + " kcal");
    }
  }
}
