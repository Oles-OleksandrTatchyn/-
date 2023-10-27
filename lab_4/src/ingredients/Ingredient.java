package ingredients;

public class Ingredient {
  private String name;
  private int calories;

  public Ingredient(String name, int calories) {
    this.name = name;
    this.calories = calories;
  }

  public String getName() {
    return name;
  }

  public int getCalories() {
    return calories;
  }
}
