package commands;

import ingredients.Ingredient;
import salad.Salad;
import ingredients.Spice;
import ingredients.Sauce;
import ingredients.Vegetable;

import java.util.Scanner;

public class AddIngredientCommand implements Command {
  private Scanner scanner;
  private Salad salad;

  public AddIngredientCommand(Scanner scanner, Salad salad) {
    this.scanner = scanner;
    this.salad = salad;
  }

  @Override
  public void execute() {
    System.out.print("Enter the name of the ingredient: ");
    scanner.nextLine();
    String name = scanner.nextLine();
    System.out.print("Enter the calorie content of the ingredient: ");
    int calories = Integer.parseInt(scanner.nextLine());

    System.out.println("Select the type of ingredient:");
    System.out.println("1. Spice");
    System.out.println("2. Sauce");
    System.out.println("3. Vegetable");
    int typeChoice = Integer.parseInt(scanner.nextLine());

    Ingredient ingredient = null;

    switch (typeChoice) {
      case 1:
        System.out.print("Enter the flavor profile of the spice: ");
        String flavorProfile = scanner.nextLine();
        ingredient = new Spice(name, calories, flavorProfile);
        break;
      case 2:
        System.out.print("Enter the spiciness level of the sauce: ");
        int spicinessLevel = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the list of ingredients for the sauce: ");
        String ingredientsList = scanner.nextLine();
        ingredient = new Sauce(name, calories, spicinessLevel, ingredientsList);
        break;
      case 3:
        String type;
        do {
          System.out.print("Enter the type of vegetable (fats/carbs(carbohydrates)/fiber/proteins): ");
          type = scanner.nextLine();
        } while (!type.matches("fats|carbs|fiber|proteins"));
        System.out.print("Enter the vitamin content of the vegetable: ");
        String vitaminContent = scanner.nextLine();
        ingredient = new Vegetable(name, calories, type, vitaminContent);
        break;
      default:
        System.out.println("Invalid ingredient type.");
        return;
    }

    salad.addIngredient(ingredient);
    System.out.println("Ingredient added to the salad.");
  }
}
