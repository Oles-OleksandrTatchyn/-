package ingredients;

public class Sauce extends Ingredient {
  private int spicinessLevel;
  private String ingredientsList;

  public Sauce(String name, int calories, int spicinessLevel, String ingredientsList) {
    super(name, calories);
    this.spicinessLevel = spicinessLevel;
    this.ingredientsList = ingredientsList;
  }

  public int getSpicinessLevel() {
    return spicinessLevel;
  }

  public String getIngredientsList() {
    return ingredientsList;
  }

  @Override
  public String getIngredientType() {
    return "Sauce";
  }
}