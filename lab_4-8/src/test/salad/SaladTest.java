package salad;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import ingredients.Ingredient;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SaladTest {

    private Salad salad;

    @Before
    public void setUp() {
        salad = new Salad();
    }

    @Test
    public void testAddIngredient() {
        Ingredient ingredient = mock(Ingredient.class);

        salad.addIngredient(ingredient);

        assertEquals(1, salad.getIngredients().size());
        assertEquals(ingredient, salad.getIngredients().get(0));
    }

    @Test
    public void testAddIngredients() {
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);
        List<Ingredient> ingredientList = Arrays.asList(ingredient1, ingredient2);

        salad.addIngredients(ingredientList);

        assertEquals(2, salad.getIngredients().size());
        assertEquals(ingredient1, salad.getIngredients().get(0));
        assertEquals(ingredient2, salad.getIngredients().get(1));
    }

    @Test
    public void testCalculateCalories() {
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);
        when(ingredient1.getCalories()).thenReturn(100);
        when(ingredient2.getCalories()).thenReturn(200);
        List<Ingredient> ingredientList = Arrays.asList(ingredient1, ingredient2);
        salad.addIngredients(ingredientList);

        int totalCalories = salad.calculateCalories();

        assertEquals(300, totalCalories);
    }

    @Test
    public void testSortIngredients() {
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);
        Ingredient ingredient3 = mock(Ingredient.class);
        when(ingredient1.getName()).thenReturn("Tomato");
        when(ingredient2.getName()).thenReturn("Cucumber");
        when(ingredient3.getName()).thenReturn("Carrot");
        List<Ingredient> ingredientList = Arrays.asList(ingredient1, ingredient2, ingredient3);
        salad.addIngredients(ingredientList);

        salad.sortIngredients(Comparator.comparing(Ingredient::getName));

        List<Ingredient> sortedIngredients = salad.getIngredients();
        assertEquals("Carrot", sortedIngredients.get(0).getName());
        assertEquals("Cucumber", sortedIngredients.get(1).getName());
        assertEquals("Tomato", sortedIngredients.get(2).getName());
    }

    @Test
    public void testGetIngredientsInCalorieRange() {
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);
        Ingredient ingredient3 = mock(Ingredient.class);
        when(ingredient1.getCalories()).thenReturn(100);
        when(ingredient2.getCalories()).thenReturn(200);
        when(ingredient3.getCalories()).thenReturn(300);
        List<Ingredient> ingredientList = Arrays.asList(ingredient1, ingredient2, ingredient3);
        salad.addIngredients(ingredientList);

        List<Ingredient> result = salad.getIngredientsInCalorieRange(150, 250);

        assertEquals(1, result.size());
        assertEquals(ingredient2, result.get(0));
    }
}
