package commands;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import commands.CalculateCaloriesCommand;
import salad.Salad;
import ingredients.Vegetable;
import ingredients.Spice;

public class CalculateCaloriesCommandTest {

    private CalculateCaloriesCommand calculateCaloriesCommand;
    private Salad salad;

    @BeforeEach
    public void setup() {
        salad = new Salad();
        calculateCaloriesCommand = new CalculateCaloriesCommand(salad);
    }

    @Test
    public void testCalculateCaloriesWithIngredients() {
        Vegetable veg1 = new Vegetable("Carrot", 50, "Vegetable", "Vitamin A");
        Vegetable veg2 = new Vegetable("Broccoli", 30, "Vegetable", "Vitamin C");
        Spice spice = new Spice("Paprika", 10, "Spicy");

        salad.addIngredient(veg1);
        salad.addIngredient(veg2);
        salad.addIngredient(spice);

        calculateCaloriesCommand.execute();

        int totalCalories = salad.calculateCalories();
        assertEquals(90, totalCalories);
    }

    @Test
    public void testCalculateCaloriesWithNoIngredients() {
        calculateCaloriesCommand.execute();

        int totalCalories = salad.calculateCalories();
        assertEquals(0, totalCalories);
    }
}
