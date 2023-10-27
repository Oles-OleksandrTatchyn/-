package ingredients;

public class Spice extends Ingredient {
  private String flavorProfile;

  public Spice(String name, int calories, String flavorProfile) {
    super(name, calories);
    this.flavorProfile = flavorProfile;
  }

  public String getFlavorProfile() {
    return flavorProfile;
  }

  @Override
  public String getIngredientType() {
    return "Spice";
  }
}
