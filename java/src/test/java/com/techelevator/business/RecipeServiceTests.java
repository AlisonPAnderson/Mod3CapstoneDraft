package com.techelevator.business;

import com.techelevator.model.Ingredient;
import com.techelevator.model.Meal;
import com.techelevator.model.Recipe;
import com.techelevator.model.User;
import com.techelevator.repository.IngredientRepository;
import com.techelevator.repository.RecipeRepository;
import com.techelevator.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Map;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RecipeServiceTests {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    IngredientService ingredientService;
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    RecipeService recipeService;
    @Autowired
    MealService mealService;

    @Test
    public void recipeIdIsNotNull() {
        Recipe recipe = Recipe.builder()
                .recipeName("TestRecipeName")
                .recipeInstructions("TestRecipeInstructions")
                .category("TestCategory")
                .build();
        recipe = recipeService.createRecipe(recipe.getRecipeName(), recipe.getRecipeInstructions(), recipe.getCategory());

        Assertions.assertThat(recipe.getRecipeId()).isNotNull();
    }

//    @Test
//    public void recipeIngredientsIdIsNotNull() {
//        Recipe recipe = Recipe.builder()
//                .recipeName("TestRecipeName")
//                .recipeInstructions("TestRecipeInstructions")
//                .category("TestCategory")
//                .build();
//        Ingredient ingredient = Ingredient.builder()
//                .ingredientName("TestIngredient")
//                .ingredientCategory("TestCategory")
//                .build();
//
//        recipe = recipeService.createRecipe(recipe.getRecipeName(), recipe.getRecipeInstructions(), recipe.getCategory());
//        ingredient = ingredientService.createIngredient(ingredient.getIngredientName(), ingredient.getIngredientCategory());
//
//        Map<Long, Ingredient> testRecipeIngredients = recipeService.addIngredientToRecipe(recipe.getRecipeId(), ingredient.getIngredientId());
//
//        Assertions.assertThat(testRecipeIngredients.get(recipe.getRecipeId())).isNotNull();
//    }
//
//    @Test
//    public void userRecipeIdIsNotNull() {
//        User user = User.builder()
//                .username("TestUsername")
//                .password("TestPassword")
//                .build();
//        Recipe recipe = Recipe.builder()
//                .recipeName("TestRecipeName")
//                .recipeInstructions("TestRecipeInstructions")
//                .category("TestCategory")
//                .build();
//
//        user = userService.create(user.getUsername(), user.getPassword());
//        recipe = recipeService.createRecipe(recipe.getRecipeName(), recipe.getRecipeInstructions(), recipe.getCategory());
//
//        Map<Long, Recipe> testUserRecipes = recipeService.addRecipeToUserRecipes(user.getUserId(), recipe.getRecipeId());
//
//        Assertions.assertThat(testUserRecipes.get(user.getUserId())).isNotNull();
//    }
//
//    @Test
//    public void mealRecipeIdIsNotNull() {
//        Meal meal = Meal.builder()
//                .mealName("TestMealName")
//                .build();
//        Recipe recipe = Recipe.builder()
//                .recipeName("TestRecipeName")
//                .recipeInstructions("TestRecipeInstructions")
//                .category("TestCategory")
//                .build();
//        recipe = recipeService.createRecipe(recipe.getRecipeName(), recipe.getRecipeInstructions(), recipe.getCategory());
//        meal = mealService.createMeal(meal.getMealName());
//        Map<Long, Recipe> testMealRecipes = recipeService.addRecipeToMeal(meal.getMealId(), recipe.getRecipeId());
//
//        Assertions.assertThat(testMealRecipes.get(meal.getMealId())).isNotNull();
//    }

    @Test
    public void deletedRecipeIsNull() {
        Recipe recipe = Recipe.builder()
                .recipeName("TestRecipeName")
                .recipeInstructions("TestRecipeInstructions")
                .category("TestCategory")
                .build();

        recipe = recipeService.createRecipe(recipe.getRecipeName(), recipe.getRecipeInstructions(), recipe.getCategory());
        recipeService.deleteRecipe(recipe.getRecipeId());

        Recipe testRecipe = recipeRepository.findByRecipeId(recipe.getRecipeId());

        Assertions.assertThat(testRecipe).isNull();
    }

}
