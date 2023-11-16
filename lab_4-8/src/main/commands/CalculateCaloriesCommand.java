package commands;

import salad.Salad;

public class CalculateCaloriesCommand implements Command {
  private Salad salad;

  public CalculateCaloriesCommand(Salad salad) {
    this.salad = salad;
  }

  @Override
  public void execute() {
    int totalCalories = salad.calculateCalories();
    System.out.println("Total calorie content of the salad: " + totalCalories + " kcal");
  }
}
