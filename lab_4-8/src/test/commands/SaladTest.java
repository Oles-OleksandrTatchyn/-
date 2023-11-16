package commands;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import salad.Salad;
import ingredients.Vegetable;

public class SaladTest {
	@Test
	public void testAddIngredient() {
		Salad salad = new Salad();
		Vegetable ingredient = new Vegetable("Cucumber", 10, "fats", "Vitamin A, Vitamin K");

		salad.addIngredient(ingredient);
		List<ingredients.Ingredient> ingredients = salad.getIngredients();

		assertTrue(ingredients.contains(ingredient));
	}

	@Test
	public void testCalculateCalories() {
		Salad salad = new Salad();
		Vegetable ingredient1 = new Vegetable("Carrot", 25, "carbs", "Vitamin A, Vitamin K");
		Vegetable ingredient2 = new Vegetable("Lettuce", 5, "fiber", "Vitamin C");

		salad.addIngredient(ingredient1);
		salad.addIngredient(ingredient2);

		int totalCalories = salad.calculateCalories();

		assertEquals(30, totalCalories);
	}

	@Test
	public void testGetIngredientsInCalorieRange() {
		Salad salad = new Salad();
		Vegetable ingredient1 = new Vegetable("Carrot", 25, "carbs", "Vitamin A, Vitamin K");
		Vegetable ingredient2 = new Vegetable("Lettuce", 5, "fiber", "Vitamin C");
		Vegetable ingredient3 = new Vegetable("Cabbage", 20, "fiber", "Vitamin C");

		salad.addIngredient(ingredient1);
		salad.addIngredient(ingredient2);
		salad.addIngredient(ingredient3);

		List<ingredients.Ingredient> result = salad.getIngredientsInCalorieRange(10, 25);

		assertEquals(2, result.size());
		assertTrue(result.contains(ingredient1));
		assertTrue(result.contains(ingredient3));
	}
}