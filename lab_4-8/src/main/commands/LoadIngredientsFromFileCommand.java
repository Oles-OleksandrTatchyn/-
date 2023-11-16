package commands;

import salad.Salad;
import ingredients.Spice;
import ingredients.Sauce;
import ingredients.Vegetable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadIngredientsFromFileCommand implements Command {
  private Scanner scanner;
  private Salad salad;

  public LoadIngredientsFromFileCommand(Scanner scanner, Salad salad) {
    this.scanner = scanner;
    this.salad = salad;
  }

  @Override
  public void execute() {
    System.out.println("Enter the path to the file containing ingredients:");

    String filePath = scanner.next();

    try {
      File file = new File(filePath);
      Scanner fileScanner = new Scanner(file);

      while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine().trim();
        if (line.isEmpty()) {
          continue;
        }

        if (line.startsWith("Ingredient_type:")) {
          String ingredientType = line.split(":")[1].trim();

          switch (ingredientType) {
            case "Vegetable":
              processVegetable(fileScanner);
              break;
            case "Sauce":
              processSauce(fileScanner);
              break;
            case "Spice":
              processSpice(fileScanner);
              break;
          }
        }
      }

      fileScanner.close();
      System.out.println("Ingredients loaded from the file and added to the salad.");
    } catch (FileNotFoundException e) {
      System.out.println("File not found: " + filePath);
    }
  }

  private void processVegetable(Scanner fileScanner) {
    String name = "";
    int calories = 0;
    String type = "";
    String vitaminContent = "";

    while (fileScanner.hasNextLine()) {
      String line = fileScanner.nextLine().trim();
      if (line.isEmpty()) {
        break;
      }

      if (line.startsWith("Name:")) {
        name = line.split(":")[1].trim();
      } else if (line.startsWith("Calories:")) {
        calories = Integer.parseInt(line.split(":")[1].trim());
      } else if (line.startsWith("Type:")) {
        type = line.split(":")[1].trim();
      } else if (line.startsWith("Vitamin Content:")) {
        vitaminContent = line.split(":")[1].trim();
      }
    }

    salad.addIngredient(new Vegetable(name, calories, type, vitaminContent));
  }

  private void processSauce(Scanner fileScanner) {
    String name = "";
    int calories = 0;
    int spicinessLevel = 0;
    String ingredientsList = "";

    while (fileScanner.hasNextLine()) {
      String line = fileScanner.nextLine().trim();
      if (line.isEmpty()) {
        break;
      }

      if (line.startsWith("Name:")) {
        name = line.split(":")[1].trim();
      } else if (line.startsWith("Calories:")) {
        calories = Integer.parseInt(line.split(":")[1].trim());
      } else if (line.startsWith("Spiciness Level:")) {
        spicinessLevel = Integer.parseInt(line.split(":")[1].trim());
      } else if (line.startsWith("Ingredients List:")) {
        ingredientsList = line.split(":")[1].trim();
      }
    }

    salad.addIngredient(new Sauce(name, calories, spicinessLevel, ingredientsList));
  }

  private void processSpice(Scanner fileScanner) {
    String name = "";
    int calories = 0;
    String flavorProfile = "";

    while (fileScanner.hasNextLine()) {
      String line = fileScanner.nextLine().trim();
      if (line.isEmpty()) {
        break;
      }

      if (line.startsWith("Name:")) {
        name = line.split(":")[1].trim();
      } else if (line.startsWith("Calories:")) {
        calories = Integer.parseInt(line.split(":")[1].trim());
      } else if (line.startsWith("Flavor Profile:")) {
        flavorProfile = line.split(":")[1].trim();
      }
    }

    salad.addIngredient(new Spice(name, calories, flavorProfile));
  }
}
