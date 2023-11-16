package ingredients;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SpiceTest {

    @Test
    public void testSpiceProperties() {
        String name = "TestSpice";
        int calories = 10;
        String flavorProfile = "sweet and savory";

        Spice spice = new Spice(name, calories, flavorProfile);

        assertEquals(name, spice.getName());
        assertEquals(calories, spice.getCalories());
        assertEquals(flavorProfile, spice.getFlavorProfile());
        assertEquals("Spice", spice.getIngredientType());
    }

    @Test
    public void testSetFlavorProfile() {
        Spice spice = new Spice("TestSpice", 10, "sweet and savory");

        spice.setFlavorProfile("spicy");

        assertEquals("spicy", spice.getFlavorProfile());
    }
}
