package ingredients;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VegetableTest {

    @Test
    public void testVegetableProperties() {
        String name = "TestVegetable";
        int calories = 30;
        String type = "carbs";
        String vitaminContent = "Vitamin A, Vitamin C";

        Vegetable vegetable = new Vegetable(name, calories, type, vitaminContent);

        assertEquals(name, vegetable.getName());
        assertEquals(calories, vegetable.getCalories());
        assertEquals(type, vegetable.getType());
        assertEquals(vitaminContent, vegetable.getVitaminContent());
        assertEquals("Vegetable", vegetable.getIngredientType());
    }

    @Test
    public void testSetType() {
        Vegetable vegetable = new Vegetable("TestVegetable", 30, "carbs", "Vitamin A, Vitamin C");

        vegetable.setType("fiber");

        assertEquals("fiber", vegetable.getType());
    }

    @Test
    public void testSetVitaminContent() {
        Vegetable vegetable = new Vegetable("TestVegetable", 30, "carbs", "Vitamin A, Vitamin C");

        vegetable.setVitaminContent("Vitamin B6, Folate");

        assertEquals("Vitamin B6, Folate", vegetable.getVitaminContent());
    }
}
