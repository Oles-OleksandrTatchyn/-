package ingredients;

public class Spice extends Ingredient {
  private int spiceLevel;
  private String flavorProfile;

  public Spice(String name, int calories, int spiceLevel, String flavorProfile) {
    super(name, calories);
    this.spiceLevel = spiceLevel;
    this.flavorProfile = flavorProfile;
  }

  public int getSpiceLevel() {
    return spiceLevel;
  }

  public String getFlavorProfile() {
    return flavorProfile;
  }
}
