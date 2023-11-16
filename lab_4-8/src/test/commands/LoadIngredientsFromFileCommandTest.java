package commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import salad.Salad;
import commands.LoadIngredientsFromFileCommand;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class LoadIngredientsFromFileCommandTest {

    @Test
    public void testLoadIngredientsFromFile() {
        String input = "X:\\ingredients.txt\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Salad salad = new Salad();
        LoadIngredientsFromFileCommand loadIngredientsCommand = new LoadIngredientsFromFileCommand(new Scanner(System.in), salad);

        loadIngredientsCommand.execute();

        assertEquals(4, salad.getIngredients().size());

        assertTrue(salad.getIngredients().get(0).getIngredientType().equals("Vegetable"));
        assertEquals("meat", salad.getIngredients().get(0).getName());
        assertEquals(422, salad.getIngredients().get(0).getCalories());
        assertTrue(salad.getIngredients().get(1).getIngredientType().equals("Sauce"));
        assertEquals("orange_sauce", salad.getIngredients().get(1).getName());
        assertEquals(200, salad.getIngredients().get(1).getCalories());
        assertTrue(salad.getIngredients().get(2).getIngredientType().equals("Spice"));
        assertEquals("super_spice", salad.getIngredients().get(2).getName());
        assertEquals(40, salad.getIngredients().get(2).getCalories());
        assertTrue(salad.getIngredients().get(3).getIngredientType().equals("Vegetable"));
        assertEquals("tomato", salad.getIngredients().get(3).getName());
        assertEquals(300, salad.getIngredients().get(3).getCalories());
    }
}
