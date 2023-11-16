package ingredients;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SauceTest {

    @Test
    public void testSauceProperties() {
        String name = "TestSauce";
        int calories = 50;
        int spicinessLevel = 3;
        String ingredientsList = "tomato, garlic, salt";

        Sauce sauce = new Sauce(name, calories, spicinessLevel, ingredientsList);

        assertEquals(name, sauce.getName());
        assertEquals(calories, sauce.getCalories());
        assertEquals(spicinessLevel, sauce.getSpicinessLevel());
        assertEquals(ingredientsList, sauce.getIngredientsList());
        assertEquals("Sauce", sauce.getIngredientType());
    }

    @Test
    public void testSetSpicinessLevel() {
        Sauce sauce = new Sauce("TestSauce", 50, 3, "tomato, garlic, salt");

        sauce.setSpicinessLevel(4);

        assertEquals(4, sauce.getSpicinessLevel());
    }

    @Test
    public void testSetIngredientsList() {
        Sauce sauce = new Sauce("TestSauce", 50, 3, "tomato, garlic, salt");

        sauce.setIngredientsList("tomato, garlic, salt, pepper");

        assertEquals("tomato, garlic, salt, pepper", sauce.getIngredientsList());
    }
}
