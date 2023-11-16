package commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import salad.Salad;
import commands.AddIngredientCommand;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class AddIngredientCommandTest {

    @Test
    public void testAddSpiceToSalad() {
        String input = "\nSalt\n50\n1\nSalty\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Salad salad = new Salad();
        AddIngredientCommand addIngredientCommand = new AddIngredientCommand(new Scanner(System.in), salad);

        addIngredientCommand.execute();

        assertEquals(1, salad.getIngredients().size());
        assertTrue(salad.getIngredients().get(0).getIngredientType().equals("Spice"));
        assertTrue(salad.getIngredients().get(0).getName().equals("Salt"));
        assertEquals(50, salad.getIngredients().get(0).getCalories());
    }

    @Test
    public void testAddVegetableToSalad() {
        String input = "\nCarrot\n30\n3\ncarbs\nVitamin A\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Salad salad = new Salad();
        AddIngredientCommand addIngredientCommand = new AddIngredientCommand(new Scanner(System.in), salad);

        addIngredientCommand.execute();

        assertEquals(1, salad.getIngredients().size());
        assertTrue(salad.getIngredients().get(0).getIngredientType().equals("Vegetable"));
        assertTrue(salad.getIngredients().get(0).getName().equals("Carrot"));
        assertEquals(30, salad.getIngredients().get(0).getCalories());
    }
}