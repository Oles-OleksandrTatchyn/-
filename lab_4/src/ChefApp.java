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
      System.out.println("Оберіть дію:");
      System.out.println("1. Додати інгредієнт до салату");
      System.out.println("2. Розрахувати калорійність салату");
      System.out.println("3. Сортувати інгредієнти");
      System.out.println("4. Знайти інгредієнти за діапазоном калорійності");
      System.out.println("5. Вийти");

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
          System.out.println("До побачення!");
          scanner.close();
          return;
        default:
          System.out.println("Невірний вибір. Спробуйте ще раз.");
      }
    }
  }

  private static int getUserChoice(Scanner scanner) {
    try {
      return scanner.nextInt();
    } catch (InputMismatchException e) {
      // Очищення буфера вводу в разі введення некоректних даних
      scanner.nextLine();
      return -1;
    }
  }

  private static void addIngredientToSalad(Scanner scanner, Salad salad) {
    System.out.print("Введіть назву інгредієнта: ");
    scanner.nextLine(); // Очищення буфера
    String name = scanner.nextLine();
    System.out.print("Введіть калорійність інгредієнта: ");
    int calories = getUserChoice(scanner);

    salad.addIngredient(new Ingredient(name, calories));
    System.out.println("Інгредієнт додано до салату.");
  }

  private static void calculateCaloriesOfSalad(Salad salad) {
    int totalCalories = salad.calculateCalories();
    System.out.println("Загальна калорійність салату: " + totalCalories + " ккал");
  }

  private static void sortIngredientsMenu(Scanner scanner, Salad salad) {
    System.out.println("Оберіть спосіб сортування:");
    System.out.println("1. По назві");
    System.out.println("2. За калорійністю");

    int sortChoice = getUserChoice(scanner);

    if (sortChoice == 1) {
      salad.sortIngredients(Comparator.comparing(Ingredient::getName));
      System.out.println("Інгредієнти сортовані за назвою.");
    } else if (sortChoice == 2) {
      salad.sortIngredients(Comparator.comparing(Ingredient::getCalories));
      System.out.println("Інгредієнти сортовані за калорійністю.");
    } else {
      System.out.println("Невірний вибір для сортування.");
    }
  }

  private static void findIngredientsInCalorieRange(Scanner scanner, Salad salad) {
    System.out.print("Введіть мінімальну калорійність: ");
    int minCalories = getUserChoice(scanner);
    System.out.print("Введіть максимальну калорійність: ");
    int maxCalories = getUserChoice(scanner);

    List<Ingredient> result = salad.getIngredientsInCalorieRange(minCalories, maxCalories);

    System.out.println("Інгредієнти в діапазоні калорійності " + minCalories + " - " + maxCalories + " ккал:");
    for (Ingredient ingredient : result) {
      System.out.println(ingredient.getName() + " - " + ingredient.getCalories() + " ккал");
    }
  }
}
