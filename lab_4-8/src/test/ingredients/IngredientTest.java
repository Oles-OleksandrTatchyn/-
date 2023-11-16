package ingredients;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IngredientTest {

    @Test
    public void testIngredientProperties() {
        String name = "TestIngredient";
        int calories = 100;

        Ingredient ingredient = new Ingredient(name, calories);

        assertEquals(name, ingredient.getName());
        assertEquals(calories, ingredient.getCalories());
        assertEquals("Ingredient", ingredient.getIngredientType());
    }

    @Test
    public void testSetCalories() {
        Ingredient ingredient = new Ingredient("TestIngredient", 100);

        ingredient.setCalories(150);

        assertEquals(150, ingredient.getCalories());
    }
}
