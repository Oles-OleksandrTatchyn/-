package commands;

import salad.Salad;
import ingredients.Ingredient;
import ingredients.Sauce;
import ingredients.Spice;
import ingredients.Vegetable;

import java.util.Scanner;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;

public class SortIngredientsCommand implements Command {
  private Scanner scanner;
  private Salad salad;

  public SortIngredientsCommand(Scanner scanner, Salad salad) {
    this.scanner = scanner;
    this.salad = salad;
  }


  @Override
  public void execute() {
    System.out.println("\nChoose a sorting method:");
    System.out.println("1. By name");
    System.out.println("2. By calorie content");
    System.out.println("3. By ingredient type\n");

    int sortChoice = getUserChoice(scanner);

    if (sortChoice == 1) {
      salad.sortIngredients(Comparator.comparing(Ingredient::getName));
      System.out.println("\nIngredients sorted by name:");
      printIngredients(salad);
    } else if (sortChoice == 2) {
      salad.sortIngredients(Comparator.comparing(Ingredient::getCalories));
      System.out.println("\nIngredients sorted by calorie content:");
      printIngredients(salad);
    } else if (sortChoice == 3) {
      salad.sortIngredients(Comparator.comparing(ingredient -> ingredient.getClass().getSimpleName()));
      System.out.println("\nIngredients sorted by ingredient type:");
      printIngredientsWithType(salad);
    } else {
      System.out.println("\nInvalid choice for sorting.");
    }
  }

  private static void printIngredients(Salad salad) {
    List<Ingredient> ingredients = salad.getIngredients();
    for (Ingredient ingredient : ingredients) {
      System.out.println("Name: " + ingredient.getName());
      System.out.println("Calories: " + ingredient.getCalories() + " kcal");
      if (ingredient instanceof Spice) {
        Spice spice = (Spice) ingredient;
        System.out.println("Flavor Profile: " + spice.getFlavorProfile());
      } else if (ingredient instanceof Sauce) {
        Sauce sauce = (Sauce) ingredient;
        System.out.println("Spiciness Level: " + sauce.getSpicinessLevel());
        System.out.println("Ingredients List: " + sauce.getIngredientsList());
      } else if (ingredient instanceof Vegetable) {
        Vegetable vegetable = (Vegetable) ingredient;
        System.out.println("Type: " + vegetable.getType());
        System.out.println("Vitamin Content: " + vegetable.getVitaminContent());
      }
      System.out.println();
    }
  }

  private static void printIngredientsWithType(Salad salad) {
    List<Ingredient> ingredients = salad.getIngredients();
    System.out.println("Ingredients in the salad:");
    for (Ingredient ingredient : ingredients) {
      System.out.println("Name: " + ingredient.getName());
      System.out.println("Calories: " + ingredient.getCalories() + " kcal");
      System.out.println("Type: " + ingredient.getClass().getSimpleName());
      System.out.println();
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
