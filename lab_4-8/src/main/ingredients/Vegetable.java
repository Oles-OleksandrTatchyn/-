package ingredients;

public class Vegetable extends Ingredient {
  private String type;
  private String vitaminContent;

  public Vegetable(String name, int calories, String type, String vitaminContent) {
    super(name, calories);
    this.type = type;
    this.vitaminContent = vitaminContent;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getVitaminContent() {
    return vitaminContent;
  }

  public void setVitaminContent(String vitaminContent) {
    this.vitaminContent = vitaminContent;
  }

  @Override
  public String getIngredientType() {
    return "Vegetable";
  }
}