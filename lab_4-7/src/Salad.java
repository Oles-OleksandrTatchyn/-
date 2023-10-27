import ingredients.Ingredient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Salad {
  private List<Ingredient> ingredients = new ArrayList<>();

  public void addIngredient(Ingredient ingredient) {
    ingredients.add(ingredient);
  }

  public int calculateCalories() {
    int totalCalories = 0;
    for (Ingredient ingredient : ingredients) {
      totalCalories += ingredient.getCalories();
    }
    return totalCalories;
  }

  public void sortIngredients(Comparator<Ingredient> comparator) {
    Collections.sort(ingredients, comparator);
  }

  public List<Ingredient> getIngredientsInCalorieRange(int minCalories, int maxCalories) {
    List<Ingredient> result = new ArrayList<>();
    for (Ingredient ingredient : ingredients) {
      int calories = ingredient.getCalories();
      if (calories >= minCalories && calories <= maxCalories) {
        result.add(ingredient);
      }
    }
    return result;
  }
  
  public List<Ingredient> getIngredients() {
    return ingredients;
  }
}
