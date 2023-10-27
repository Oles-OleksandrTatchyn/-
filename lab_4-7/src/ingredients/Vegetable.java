// package ingredients;

// public class Vegetable extends Ingredient {
//   private String type;
//   private int fiberContent;
//   private String vitaminContent;

//   public Vegetable(String name, int calories, String type, int fiberContent, String vitaminContent) {
//     super(name, calories);
//     this.type = type;
//     this.fiberContent = fiberContent;
//     this.vitaminContent = vitaminContent;
//   }

//   public String getType() {
//     return type;
//   }

//   public int getFiberContent() {
//     return fiberContent;
//   }

//   public String getVitaminContent() {
//     return vitaminContent;
//   }

//   @Override
//   public String getIngredientType() {
//     return "Vegetable";
//   }
// }

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

  public String getVitaminContent() {
    return vitaminContent;
  }

  @Override
  public String getIngredientType() {
    return "Vegetable";
  }
}