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

  public void setSpicinessLevel(int spicinessLevel) {
    this.spicinessLevel = spicinessLevel;
  }

  public String getIngredientsList() {
    return ingredientsList;
  }

  public void setIngredientsList(String ingredientsList) {
    this.ingredientsList = ingredientsList;
  }

  @Override
  public String getIngredientType() {
    return "Sauce";
  }
}