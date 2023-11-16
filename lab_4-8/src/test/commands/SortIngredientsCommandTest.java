//package commands;
//
//import static org.junit.Assert.assertEquals;
//
//import ingredients.Sauce;
//import ingredients.Spice;
//import ingredients.Vegetable;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import salad.Salad;
//import commands.SortIngredientsCommand;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.InputStream;
//import java.io.PrintStream;
//import java.util.Scanner;
//
//public class SortIngredientsCommandTest {
//
//    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//    private final PrintStream originalOut = System.out;
//
//    @Before
//    public void setUpStreams() {
//        System.setOut(new PrintStream(outContent));
//    }
//
//    @After
//    public void restoreStreams() {
//        System.setOut(originalOut);
//    }
//
//    @Test
//    public void testSortIngredientsByName() {
//        String input = "1\n";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        Salad salad = new Salad();
//        salad.addIngredient(new Spice("Cumin", 200, "Aromatic"));
//        salad.addIngredient(new Sauce("Tomato Sauce", 150, 2, "Tomatoes, Salt, Sugar"));
//        salad.addIngredient(new Vegetable("Carrot", 50, "Carrot", "Vitamin A"));
//
//        SortIngredientsCommand sortIngredientsCommand = new SortIngredientsCommand(new Scanner(System.in), salad);
//
//        sortIngredientsCommand.execute();
//
//        assertEquals("""
//
//                Choose a sorting method:
//                1. By name
//                2. By calorie content
//                3. By ingredient type
//
//
//                Ingredients sorted by name:
//                Name: Carrot
//                Calories: 50 kcal
//                Type: Carrot
//                Vitamin Content: Vitamin A
//
//                Name: Cumin
//                Calories: 200 kcal
//                Flavor Profile: Aromatic
//
//                Name: Tomato Sauce
//                Calories: 150 kcal
//                Spiciness Level: 2
//                Ingredients List: Tomatoes, Salt, Sugar
//
//                """, outContent.toString());
//    }
//}
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

public class SortIngredientsCommandTest {

    @Test
    public void testSortIngredientsByName() {
        Salad salad = new Salad();
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Sauce("Tomato Sauce", 50, 3, "Tomatoes, Salt"));
        ingredients.add(new Vegetable("Carrot", 30, "Carrot type", "Vitamin C"));
        ingredients.add(new Spice("Cinnamon", 10, "Sweet"));
        salad.addIngredients(ingredients);

        ConsoleInputWrapper mockScanner = Mockito.mock(ConsoleInputWrapper.class);
        Mockito.when(mockScanner.nextInt()).thenReturn(1);

        SortIngredientsCommand sortCommand = new SortIngredientsCommand(mockScanner, salad);

        sortCommand.execute();

        List<Ingredient> sortedIngredients = salad.getIngredients();
        assertEquals("Cinnamon", sortedIngredients.get(0).getName());
        assertEquals("Carrot", sortedIngredients.get(1).getName());
        assertEquals("Tomato Sauce", sortedIngredients.get(2).getName());
    }

    static class ConsoleInputWrapper {
        int nextInt() {
            return 0;
        }
    }
}