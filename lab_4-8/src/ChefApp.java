// import ingredients.*;
// import java.util.Scanner;
// import java.util.InputMismatchException;
// import java.util.List;
// import java.util.Comparator;

// public class ChefApp {
//   public static void main(String[] args) {
//     Scanner scanner = new Scanner(System.in);
//     Salad salad = new Salad();

//     while (true) {
//       System.out.println("\nChoose an action:");
//       System.out.println("1. Add an ingredient to the salad");
//       System.out.println("2. Calculate the salad's calorie content");
//       System.out.println("3. Sort ingredients");
//       System.out.println("4. Find ingredients within a calorie range");
//       System.out.println("5. Exit\n");

//       int choice = getUserChoice(scanner);

//       switch (choice) {
//         case 1:
//           addIngredientToSalad(scanner, salad);
//           break;
//         case 2:
//           calculateCaloriesOfSalad(salad);
//           break;
//         case 3:
//           sortIngredientsMenu(scanner, salad);
//           break;
//         case 4:
//           findIngredientsInCalorieRange(scanner, salad);
//           break;
//         case 5:
//           System.out.println("Goodbye!");
//           scanner.close();
//           return;
//         default:
//           System.out.println("Invalid choice. Please try again.");
//       }
//     }
//   }

//   private static int getUserChoice(Scanner scanner) {
//     try {
//       return scanner.nextInt();
//     } catch (InputMismatchException e) {
//       scanner.nextLine();
//       return -1;
//     }
//   }

//   private static void addIngredientToSalad(Scanner scanner, Salad salad) {
//     System.out.print("Enter the name of the ingredient: ");
//     scanner.nextLine();
//     String name = scanner.nextLine();
//     System.out.print("Enter the calorie content of the ingredient: ");
//     int calories = Integer.parseInt(scanner.nextLine());
  
//     System.out.println("Select the type of ingredient:");
//     System.out.println("1. Spice");
//     System.out.println("2. Sauce");
//     System.out.println("3. Vegetable");
//     int typeChoice = Integer.parseInt(scanner.nextLine());
  
//     Ingredient ingredient = null;
  
//     switch (typeChoice) {
//       case 1:
//         System.out.print("Enter the flavor profile of the spice: ");
//         String flavorProfile = scanner.nextLine();
//         ingredient = new Spice(name, calories, flavorProfile);
//         break;
//       case 2:
//         System.out.print("Enter the spiciness level of the sauce: ");
//         int spicinessLevel = Integer.parseInt(scanner.nextLine());
//         System.out.print("Enter the list of ingredients for the sauce: ");
//         String ingredientsList = scanner.nextLine();
//         ingredient = new Sauce(name, calories, spicinessLevel, ingredientsList);
//         break;
//       case 3:
//         String type;
//         do {
//           System.out.print("Enter the type of vegetable (fats/carbohydrates/fiber/proteins): ");
//           type = scanner.nextLine();
//         } while (!type.matches("fats|carbohydrates|fiber|proteins"));
//         System.out.print("Enter the fiber content of the vegetable: ");
//         int fiberContent = Integer.parseInt(scanner.nextLine());
//         System.out.print("Enter the vitamin content of the vegetable: ");
//         String vitaminContent = scanner.nextLine();
//         ingredient = new Vegetable(name, calories, type, fiberContent, vitaminContent);
//         break;
//       default:
//         System.out.println("Invalid ingredient type.");
//         return;
//     }
  
//     salad.addIngredient(ingredient);
//     System.out.println("Ingredient added to the salad.");
//   }
  



//   private static void calculateCaloriesOfSalad(Salad salad) {
//     int totalCalories = salad.calculateCalories();
//     System.out.println("Total calorie content of the salad: " + totalCalories + " kcal");
//   }

//   private static void sortIngredientsMenu(Scanner scanner, Salad salad) {
//     System.out.println("\nChoose a sorting method:");
//     System.out.println("1. By name");
//     System.out.println("2. By calorie content");
//     System.out.println("3. By ingredient type");

//     int sortChoice = getUserChoice(scanner);

//     if (sortChoice == 1) {
//       salad.sortIngredients(Comparator.comparing(Ingredient::getName));
//       System.out.println("\nIngredients sorted by name:");
//       printIngredients(salad);
//     } else if (sortChoice == 2) {
//       salad.sortIngredients(Comparator.comparing(Ingredient::getCalories));
//       System.out.println("Ingredients sorted by calorie content:");
//       printIngredients(salad);
//     } else if (sortChoice == 3) {
//       salad.sortIngredients(Comparator.comparing(ingredient -> ingredient.getClass().getSimpleName()));
//       System.out.println("Ingredients sorted by ingredient type:");
//       printIngredientsWithType(salad);
//     } else {
//       System.out.println("Invalid choice for sorting.");
//     }
//   }

//   private static void printIngredients(Salad salad) {
//     List<Ingredient> ingredients = salad.getIngredients();
//     System.out.println("Ingredients in the salad:");
//     for (Ingredient ingredient : ingredients) {
//       System.out.println("Name: " + ingredient.getName());
//       System.out.println("Calories: " + ingredient.getCalories() + " kcal");
//       if (ingredient instanceof Spice) {
//         Spice spice = (Spice) ingredient;
//         System.out.println("Flavor Profile: " + spice.getFlavorProfile());
//       } else if (ingredient instanceof Sauce) {
//         Sauce sauce = (Sauce) ingredient;
//         System.out.println("Spiciness Level: " + sauce.getSpicinessLevel());
//         System.out.println("Ingredients List: " + sauce.getIngredientsList());
//       } else if (ingredient instanceof Vegetable) {
//         Vegetable vegetable = (Vegetable) ingredient;
//         System.out.println("Type: " + vegetable.getType());
//         System.out.println("Fiber Content: " + vegetable.getFiberContent() + "g");
//         System.out.println("Vitamin Content: " + vegetable.getVitaminContent());
//       }
//       System.out.println();
//     }
//   }

//   private static void printIngredients(List<Ingredient> ingredients) {
//     System.out.println("Ingredients in the list:");
//     for (Ingredient ingredient : ingredients) {
//       System.out.println("Name: " + ingredient.getName());
//       System.out.println("Calories: " + ingredient.getCalories() + " kcal");
//       if (ingredient instanceof Spice) {
//         Spice spice = (Spice) ingredient;
//         System.out.println("Flavor Profile: " + spice.getFlavorProfile());
//       } else if (ingredient instanceof Sauce) {
//         Sauce sauce = (Sauce) ingredient;
//         System.out.println("Spiciness Level: " + sauce.getSpicinessLevel());
//         System.out.println("Ingredients List: " + sauce.getIngredientsList());
//       } else if (ingredient instanceof Vegetable) {
//         Vegetable vegetable = (Vegetable) ingredient;
//         System.out.println("Type: " + vegetable.getType());
//         System.out.println("Fiber Content: " + vegetable.getFiberContent() + "g");
//         System.out.println("Vitamin Content: " + vegetable.getVitaminContent());
//       }
//       System.out.println();
//     }
//   }


//   private static void printIngredientsWithType(Salad salad) {
//     List<Ingredient> ingredients = salad.getIngredients();
//     System.out.println("Ingredients in the salad:");
//     for (Ingredient ingredient : ingredients) {
//       System.out.println("Name: " + ingredient.getName());
//       System.out.println("Calories: " + ingredient.getCalories() + " kcal");
//       System.out.println("Type: " + ingredient.getClass().getSimpleName());
//       System.out.println();
//     }
//   }

//   private static void findIngredientsInCalorieRange(Scanner scanner, Salad salad) {
//     System.out.print("Enter the minimum calorie content: ");
//     int minCalories = getUserChoice(scanner);
//     System.out.print("Enter the maximum calorie content: ");
//     int maxCalories = getUserChoice(scanner);

//     List<Ingredient> result = salad.getIngredientsInCalorieRange(minCalories, maxCalories);

//     System.out.println("Ingredients within the calorie range " + minCalories + " - " + maxCalories + " kcal:");
//     printIngredients(result);
//   }
// }



















// import ingredients.*;
// import salad.Salad;

// import java.util.Scanner;
// import java.util.InputMismatchException;
// import java.util.List;
// import java.util.Comparator;

// public class ChefApp {
//   public static void main(String[] args) {
//     Scanner scanner = new Scanner(System.in);
//     Salad salad = new Salad();

//     while (true) {
//       System.out.println("\nChoose an action:");
//       System.out.println("1. Add an ingredient to the salad");
//       System.out.println("2. Calculate the salad's calorie content");
//       System.out.println("3. Sort ingredients");
//       System.out.println("4. Find ingredients within a calorie range");
//       System.out.println("5. Exit\n");

//       int choice = getUserChoice(scanner);

//       switch (choice) {
//         case 1:
//           addIngredientToSalad(scanner, salad);
//           break;
//         case 2:
//           calculateCaloriesOfSalad(salad);
//           break;
//         case 3:
//           sortIngredientsMenu(scanner, salad);
//           break;
//         case 4:
//           findIngredientsInCalorieRange(scanner, salad);
//           break;
//         case 5:
//           System.out.println("Goodbye!");
//           scanner.close();
//           return;
//         default:
//           System.out.println("Invalid choice. Please try again.");
//       }
//     }
//   }

//   private static int getUserChoice(Scanner scanner) {
//     try {
//       return scanner.nextInt();
//     } catch (InputMismatchException e) {
//       scanner.nextLine();
//       return -1;
//     }
//   }

//   private static void addIngredientToSalad(Scanner scanner, Salad salad) {
//     System.out.print("Enter the name of the ingredient: ");
//     scanner.nextLine();
//     String name = scanner.nextLine();
//     System.out.print("Enter the calorie content of the ingredient: ");
//     int calories = Integer.parseInt(scanner.nextLine());
  
//     System.out.println("Select the type of ingredient:");
//     System.out.println("1. Spice");
//     System.out.println("2. Sauce");
//     System.out.println("3. Vegetable");
//     int typeChoice = Integer.parseInt(scanner.nextLine());
  
//     Ingredient ingredient = null;
  
//     switch (typeChoice) {
//       case 1:
//         System.out.print("Enter the flavor profile of the spice: ");
//         String flavorProfile = scanner.nextLine();
//         ingredient = new Spice(name, calories, flavorProfile);
//         break;
//       case 2:
//         System.out.print("Enter the spiciness level of the sauce: ");
//         int spicinessLevel = Integer.parseInt(scanner.nextLine());
//         System.out.print("Enter the list of ingredients for the sauce: ");
//         String ingredientsList = scanner.nextLine();
//         ingredient = new Sauce(name, calories, spicinessLevel, ingredientsList);
//         break;
//       case 3:
//         String type;
//         do {
//           System.out.print("Enter the type of vegetable (fats/carbs(carbohydrates)/fiber/proteins): ");
//           type = scanner.nextLine();
//         } while (!type.matches("fats|carbs|fiber|proteins"));
//         System.out.print("Enter the vitamin content of the vegetable: ");
//         String vitaminContent = scanner.nextLine();
//         ingredient = new Vegetable(name, calories, type, vitaminContent);
//         break;
//       default:
//         System.out.println("Invalid ingredient type.");
//         return;
//     }
  
//     salad.addIngredient(ingredient);
//     System.out.println("Ingredient added to the salad.");
//   }
  



//   private static void calculateCaloriesOfSalad(Salad salad) {
//     int totalCalories = salad.calculateCalories();
//     System.out.println("Total calorie content of the salad: " + totalCalories + " kcal");
//   }

//   private static void sortIngredientsMenu(Scanner scanner, Salad salad) {
//     System.out.println("\nChoose a sorting method:");
//     System.out.println("1. By name");
//     System.out.println("2. By calorie content");
//     System.out.println("3. By ingredient type\n");

//     int sortChoice = getUserChoice(scanner);

//     if (sortChoice == 1) {
//       salad.sortIngredients(Comparator.comparing(Ingredient::getName));
//       System.out.println("\nIngredients sorted by name:");
//       printIngredients(salad);
//     } else if (sortChoice == 2) {
//       salad.sortIngredients(Comparator.comparing(Ingredient::getCalories));
//       System.out.println("\nIngredients sorted by calorie content:");
//       printIngredients(salad);
//     } else if (sortChoice == 3) {
//       salad.sortIngredients(Comparator.comparing(ingredient -> ingredient.getClass().getSimpleName()));
//       System.out.println("\nIngredients sorted by ingredient type:");
//       printIngredientsWithType(salad);
//     } else {
//       System.out.println("\nInvalid choice for sorting.");
//     }
//   }

//   private static void printIngredients(Salad salad) {
//     List<Ingredient> ingredients = salad.getIngredients();
//     for (Ingredient ingredient : ingredients) {
//       System.out.println("Name: " + ingredient.getName());
//       System.out.println("Calories: " + ingredient.getCalories() + " kcal");
//       if (ingredient instanceof Spice) {
//         Spice spice = (Spice) ingredient;
//         System.out.println("Flavor Profile: " + spice.getFlavorProfile());
//       } else if (ingredient instanceof Sauce) {
//         Sauce sauce = (Sauce) ingredient;
//         System.out.println("Spiciness Level: " + sauce.getSpicinessLevel());
//         System.out.println("Ingredients List: " + sauce.getIngredientsList());
//       } else if (ingredient instanceof Vegetable) {
//         Vegetable vegetable = (Vegetable) ingredient;
//         System.out.println("Type: " + vegetable.getType());
//         System.out.println("Vitamin Content: " + vegetable.getVitaminContent());
//       }
//       System.out.println();
//     }
//   }

//   private static void printIngredients(List<Ingredient> ingredients) {
//     for (Ingredient ingredient : ingredients) {
//       System.out.println("Name: " + ingredient.getName());
//       System.out.println("Calories: " + ingredient.getCalories() + " kcal");
//       if (ingredient instanceof Spice) {
//         Spice spice = (Spice) ingredient;
//         System.out.println("Flavor Profile: " + spice.getFlavorProfile());
//       } else if (ingredient instanceof Sauce) {
//         Sauce sauce = (Sauce) ingredient;
//         System.out.println("Spiciness Level: " + sauce.getSpicinessLevel());
//         System.out.println("Ingredients List: " + sauce.getIngredientsList());
//       } else if (ingredient instanceof Vegetable) {
//         Vegetable vegetable = (Vegetable) ingredient;
//         System.out.println("Type: " + vegetable.getType());
//         System.out.println("Vitamin Content: " + vegetable.getVitaminContent());
//       }
//       System.out.println();
//     }
//   }


//   private static void printIngredientsWithType(Salad salad) {
//     List<Ingredient> ingredients = salad.getIngredients();
//     System.out.println("Ingredients in the salad:");
//     for (Ingredient ingredient : ingredients) {
//       System.out.println("Name: " + ingredient.getName());
//       System.out.println("Calories: " + ingredient.getCalories() + " kcal");
//       System.out.println("Type: " + ingredient.getClass().getSimpleName());
//       System.out.println();
//     }
//   }

//   private static void findIngredientsInCalorieRange(Scanner scanner, Salad salad) {
//     System.out.print("\nEnter the minimum calorie content: ");
//     int minCalories = getUserChoice(scanner);
//     System.out.print("Enter the maximum calorie content: ");
//     int maxCalories = getUserChoice(scanner);

//     List<Ingredient> result = salad.getIngredientsInCalorieRange(minCalories, maxCalories);

//     System.out.println("Ingredients within the calorie range " + minCalories + " - " + maxCalories + " kcal:");
//     printIngredients(result);
//   }
// }










import commands.*;
import salad.Salad;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;

public class ChefApp {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
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
        commands.get(choice - 1).execute();
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
