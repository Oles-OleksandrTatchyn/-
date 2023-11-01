// package commands;

// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// import ingredients.Ingredient;
// import ingredients.Sauce;
// import ingredients.Spice;
// import ingredients.Vegetable;
// import salad.Salad;

// public class LoadIngredientsFromFileCommand implements Command {
//   private Scanner scanner;
//   private Salad salad;

//   public LoadIngredientsFromFileCommand(Scanner scanner, Salad salad) {
//     this.scanner = scanner;
//     this.salad = salad;
//   }

//   @Override
//   public void execute() {
//     System.out.println("Enter the path to the file containing ingredients:");

//     String filePath = scanner.next();
//     List<Ingredient> loadedIngredients = loadIngredientsFromFile(filePath);

//     if (loadedIngredients != null) {
//       salad.addIngredients(loadedIngredients);
//       System.out.println("Ingredients loaded from the file and added to the salad.");
//     } else {
//       System.out.println("Error loading ingredients from the file.");
//     }
//   }

//   private List<Ingredient> loadIngredientsFromFile(String filePath) {
//     List<Ingredient> ingredients = new ArrayList<>();
//     try(BufferedReader reader = new BufferedReader(new FileReader(filePath)) ) {
//       // BufferedReader reader = new BufferedReader(new FileReader(filePath));
//       String line;
//       Ingredient currentIngredient = null;
//       String ingredientType = null;

//       while ((line = reader.readLine()) != null) {
//         if (line.trim().isEmpty()) {
//           // Пропустити порожні рядки
//           continue;
//         }

//         String[] parts = line.split(":");
//         if (parts.length != 2) {
//           System.out.println("Invalid data format in the file.");
//           return null;
//         }

//         String key = parts[0].trim();
//         String value = parts[1].trim();

//         if (key.equals("Name")) {
//           ingredientType = null; // Скидання поточного типу інгредієнта
//           currentIngredient = new Ingredient(value, 0);
//         } else if (key.isEmpty()) {
//           // Якщо поточний ключ порожній, це означає початок нового інгредієнта
//           if (currentIngredient != null) {
//             ingredients.add(currentIngredient);
//           }
//           currentIngredient = null;
//         } else if (currentIngredient != null) {
//           if (key.equals("Ingredient_type")) {
//             ingredientType = value;
//           } else {
//             switch (key) {
//               case "Calories":
//                 try {
//                   int calories = Integer.parseInt(value);
//                   currentIngredient.setCalories(calories);
//                 } catch (NumberFormatException e) {
//                   System.out.println("Invalid calories format in the file.");
//                   return null;
//                 }
//                 break;
//               case "Type":
//                 if (ingredientType != null) {
//                   if (ingredientType.equals("Vegetable")) {
//                     if (currentIngredient instanceof Vegetable) {
//                       ((Vegetable) currentIngredient).setType(value);
//                     }
//                   }
//                 }
//                 break;
//               case "Vitamin Content":
//                 if (ingredientType != null && ingredientType.equals("Vegetable")) {
//                   ((Vegetable) currentIngredient).setVitaminContent(value);
//                 }
//                 break;
//               case "Spiciness Level":
//                 if (ingredientType != null && ingredientType.equals("Sauce")) {
//                   try {
//                     int spicinessLevel = Integer.parseInt(value);
//                     ((Sauce) currentIngredient).setSpicinessLevel(spicinessLevel);
//                   } catch (NumberFormatException e) {
//                     System.out.println("Invalid spiciness level format in the file.");
//                     return null;
//                   }
//                 }
//                 break;
//               case "Flavor Profile":
//                 if (ingredientType != null && ingredientType.equals("Spice")) {
//                   ((Spice) currentIngredient).setFlavorProfile(value);
//                 }
//                 break;
//               case "Ingredients List":
//                 if (ingredientType != null && ingredientType.equals("Sauce")) {
//                   ((Sauce) currentIngredient).setIngredientsList(value);
//                 }
//                 break;
//             }
//           }
//         }
//       }

//       reader.close();

//       if (currentIngredient != null) {
//         // Додати останній інгредієнт до списку
//         ingredients.add(currentIngredient);
//       }

//       return ingredients;
//     } catch (IOException e) {
//       System.out.println("Error loading ingredients from the file: " + e.getMessage());
//       return null;
//     }
//   }
// }




// package commands;

// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.Scanner;

// import ingredients.Ingredient;
// import ingredients.Sauce;
// import ingredients.Spice;
// import ingredients.Vegetable;
// import salad.Salad;

// public class LoadIngredientsFromFileCommand implements Command {
//     private Scanner scanner;
//     private Salad salad;

//     public LoadIngredientsFromFileCommand(Scanner scanner, Salad salad) {
//         this.scanner = scanner;
//         this.salad = salad;
//     }

//     @Override
//     public void execute() {
//         System.out.println("Enter the path to the file containing ingredients:");

//         String filePath = scanner.next();

//         try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//             String line;
//             Ingredient ingredient = null;

//             while ((line = br.readLine()) != null) {
//                 if (line.startsWith("Name: ")) {
//                     String name = line.substring(6);
//                     int calories = 0;
//                     String ingredientType = "";
//                     String extraInfo = "";

//                     while ((line = br.readLine()) != null) {
//                         if (line.startsWith("Calories: ")) {
//                             calories = Integer.parseInt(line.substring(10));
//                         } else if (line.startsWith("Ingredient_type: ")) {
//                             ingredientType = line.substring(17);
//                         } else if (line.startsWith("Type: ")) {
//                             extraInfo = line.substring(6);
//                         } else if (line.startsWith("Flavor Profile: ")) {
//                             extraInfo = line.substring(16);
//                         } else if (line.equals("")) {
//                             break;
//                         }
//                     }

//                     if (ingredientType.equals("Spice")) {
//                         ingredient = new Spice(name, calories, extraInfo);
//                     } else if (ingredientType.equals("Sauce")) {
//                         int spicinessLevel = 0;
//                         String ingredientsList = "";

//                         while ((line = br.readLine()) != null) {
//                             if (line.startsWith("Spiciness Level: ")) {
//                                 spicinessLevel = Integer.parseInt(line.substring(17));
//                             } else if (line.startsWith("Ingredients List: ")) {
//                                 ingredientsList = line.substring(18);
//                             } else if (line.equals("")) {
//                                 break;
//                             }
//                         }

//                         ingredient = new Sauce(name, calories, spicinessLevel, ingredientsList);
//                     } else if (ingredientType.equals("Vegetable")) {
//                         while ((line = br.readLine()) != null) {
//                             if (line.startsWith("Type: ")) {
//                                 extraInfo = line.substring(6);
//                             } else if (line.startsWith("Vitamin Content: ")) {
//                                 String vitaminContent = line.substring(17);
//                                 ingredient = new Vegetable(name, calories, extraInfo, vitaminContent);
//                             } else if (line.equals("")) {
//                                 break;
//                             }
//                         }
//                     }

//                     if (ingredient != null) {
//                         salad.addIngredient(ingredient);
//                     }
//                 }
//             }
//             System.out.println("Ingredients loaded from the file and added to the salad.");
//         } catch (IOException e) {
//             System.out.println("Error reading the file: " + e.getMessage());
//         }
//     }
// }

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

                    // Process based on ingredient type
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