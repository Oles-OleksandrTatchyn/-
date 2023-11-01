package commands;

import salad.Salad;
import ingredients.Ingredient;
import ingredients.Sauce;
import ingredients.Spice;
import ingredients.Vegetable;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;

public class FindIngredientsCommand implements Command {
  private Scanner scanner;
  private Salad salad;

  public FindIngredientsCommand(Scanner scanner, Salad salad) {
    this.scanner = scanner;
    this.salad = salad;
  }

  @Override
  public void execute() {
    System.out.print("\nEnter the minimum calorie content: ");
    int minCalories = getUserChoice(scanner);
    System.out.print("Enter the maximum calorie content: ");
    int maxCalories = getUserChoice(scanner);

    List<Ingredient> result = salad.getIngredientsInCalorieRange(minCalories, maxCalories);

    System.out.println("Ingredients within the calorie range " + minCalories + " - " + maxCalories + " kcal:");
    printIngredients(result);
  }

  private static void printIngredients(List<Ingredient> ingredients) {
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

  private static int getUserChoice(Scanner scanner) {
    try {
      return scanner.nextInt();
    } catch (InputMismatchException e) {
      scanner.nextLine();
      return -1;
    }
  }
}
