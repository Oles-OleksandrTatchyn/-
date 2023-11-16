package commands;

import org.junit.Test;
import org.mockito.Mockito;

import salad.Salad;
import ingredients.Ingredient;
import ingredients.Spice;
import ingredients.Sauce;
import ingredients.Vegetable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FindIngredientsCommandTest {

    @Test
    public void testFindIngredientsByCalorieRange() {
        Salad salad = new Salad();
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Sauce("Tomato Sauce", 50, 3, "Tomatoes, Salt"));
        ingredients.add(new Vegetable("Carrot", 30, "Carrot type", "Vitamin C"));
        ingredients.add(new Spice("Cinnamon", 10, "Sweet"));
        salad.addIngredients(ingredients);

        FindIngredientsCommand findCommand = createFindCommandWithMockedScanner(salad, 20, 40);

        findCommand.execute();

        List<Ingredient> foundIngredients = salad.getIngredientsInCalorieRange(20, 40);
        assertEquals(1, foundIngredients.size());
        assertEquals("Carrot", foundIngredients.get(0).getName());
    }

    @Test
    public void testFindIngredientsByCalorieRangeNoMatches() {
        Salad salad = new Salad();
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Sauce("Tomato Sauce", 50, 3, "Tomatoes, Salt"));
        ingredients.add(new Vegetable("Carrot", 30, "Carrot type", "Vitamin C"));
        ingredients.add(new Spice("Cinnamon", 10, "Sweet"));
        salad.addIngredients(ingredients);

        FindIngredientsCommand findCommand = createFindCommandWithMockedScanner(salad, 60, 80);

        findCommand.execute();

        List<Ingredient> foundIngredients = salad.getIngredientsInCalorieRange(60, 80);
        assertEquals(0, foundIngredients.size());
    }

    private FindIngredientsCommand createFindCommandWithMockedScanner(Salad salad, int minCalories, int maxCalories) {
        ConsoleInputWrapper mockScanner = Mockito.mock(ConsoleInputWrapper.class);
        Mockito.when(mockScanner.nextInt()).thenReturn(minCalories, maxCalories);

        return new FindIngredientsCommand(mockScanner, salad);
    }

    static class ConsoleInputWrapper {
        int nextInt() {
            return 0;
        }
    }
}
