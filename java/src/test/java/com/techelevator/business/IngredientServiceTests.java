package com.techelevator.business;

import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;
import com.techelevator.model.User;
import com.techelevator.model.UserPantry;
import com.techelevator.repository.IngredientRepository;
import com.techelevator.repository.RecipeRepository;
import com.techelevator.repository.UserPantryRepository;
import com.techelevator.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IngredientServiceTests {

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
    UserPantryRepository userPantryRepository;
    @Autowired
    UserPantryService userPantryService;


    @Test
    public void ingredientIdIsNotNull() {
        Ingredient ingredient = Ingredient.builder()
                .ingredientName("TestIngredient")
                .ingredientCategory("TestCategory")
                .build();
        ingredient = ingredientService.createIngredient(ingredient.getIngredientName(), ingredient.getIngredientCategory());

        Assertions.assertThat(ingredient.getIngredientId()).isNotNull();
    }

    //fails -- unsure how to test
    @Test
    public void deletedIngredientIsNull() throws Exception {
        Ingredient ingredient = Ingredient.builder()
                .ingredientName("TestIngredient")
                .ingredientCategory("TestCategory")
                .build();

        ingredient = ingredientService.createIngredient(ingredient.getIngredientName(), ingredient.getIngredientCategory());
        Long ingredientId = ingredient.getIngredientId();

        ingredientService.deleteIngredient(ingredient.getIngredientId());

        Ingredient testIngredient = ingredientRepository.findByIngredientId(ingredientId);

        Assertions.assertThat(testIngredient).isNull();
    }

    @Test
    public void userPantryUserIdAndIngredientIdAreNotNull() {
        User user = new User();
        user = User.builder()
                .username("TestUsername")
                .password("TestPassword")
                .build();
        Ingredient ingredient = Ingredient.builder()
                .ingredientName("TestIngredient")
                .ingredientCategory("TestCategory")
                .build();
        UserPantry userPantry = UserPantry.builder()
                .userId(user.getUserId())
                .ingredientId(ingredient.getIngredientId())
                .build();
        user = userService.create(user.getUsername(), user.getPassword());

        ingredient = ingredientService.createIngredient(ingredient.getIngredientName(), ingredient.getIngredientCategory());

        userPantry = userPantryService.create(userPantry.getUserId());

        Map<Long, Ingredient> userPantryStock = userPantryService.addIngredientToUserPantry(user.getUserId(), ingredient.getIngredientId());

        Assertions.assertThat(userPantryStock.containsValue(ingredient)).isTrue();
        }

//    @Test
//    public void deletedIngredientShouldBeRemovedFromUserPantry() {
//        User user = User.builder()
//                .username("TestUsername")
//                .password("TestPassword")
//                .build();
//        Ingredient ingredient = Ingredient.builder()
//                .ingredientName("TestIngredient")
//                .ingredientCategory("TestCategory")
//                .build();
//        user = userService.create(user.getUsername(), user.getPassword());
//
//        ingredient = ingredientService.createIngredient(ingredient.getIngredientName(), ingredient.getIngredientCategory());
//
//    }

//    @Test
//    public void ingredientsNotInPantryShouldBeAddedToGroceryList() {
//        User user = User.builder()
//                .username("TestUsername")
//                .password("TestPassword")
//                .build();
//        Recipe recipe = Recipe.builder()
//                .recipeName("TestRecipe")
//                .category("TestCategory")
//                .recipeInstructions("TestInstructions")
//                .build();
//        Ingredient testIngredientInPantry = Ingredient.builder()
//                .ingredientName("TestIngredientA")
//                .ingredientCategory("TestCategory")
//                .build();
//        Ingredient testIngredientNotInPantry = Ingredient.builder()
//                .ingredientName("TestIngredientB")
//                .ingredientCategory("TestCategory")
//                .build();
//
//        user = userService.create(user.getUsername(), user.getPassword());
//        recipe = recipeService.createRecipe(recipe.getRecipeName(), recipe.getRecipeInstructions(), recipe.getCategory());
//        testIngredientNotInPantry = ingredientService.createIngredient(testIngredientNotInPantry.getIngredientName(), testIngredientNotInPantry.getIngredientCategory());
//        testIngredientInPantry = ingredientService.createIngredient(testIngredientInPantry.getIngredientName(), testIngredientInPantry.getIngredientCategory());
//        Long ingredientInPantryId = testIngredientInPantry.getIngredientId();
//        Long ingredientNotInPantryId = testIngredientNotInPantry.getIngredientId();
//
//        Map<Long, Ingredient> yuserPantry = new HashMap<>();
//        //yuserPantry = user.getXuserPantry();
//        yuserPantry.put(testIngredientInPantry.getIngredientId(), testIngredientInPantry);
//        user.setXuserPantry(yuserPantry);
//        userRepository.save(user);
//
//        Map<Long, Ingredient> recipeIngredientsMap = new HashMap<>();
//        recipeIngredientsMap.put(testIngredientInPantry.getIngredientId(), testIngredientInPantry);
//        recipeIngredientsMap.put(testIngredientNotInPantry.getIngredientId(), testIngredientNotInPantry);
//        recipe.setRecipeIngredients(recipeIngredientsMap);
//        recipeRepository.save(recipe);
//
//        List<Ingredient> groceryList = ingredientService.makeGroceryListFromRecipeIngredientsAndPantryIngredients(user.getUserId(), recipe.getRecipeId());
//        System.out.println(groceryList.toString());
//        assertTrue(groceryList.contains(testIngredientNotInPantry));
//    }

//    @Test
//    public void ingredientsInPantryShouldNotBeAddedToGroceryList() {
//        User user = User.builder()
//                .username("TestUsername")
//                .password("TestPassword")
//                .build();
//        Recipe recipe = Recipe.builder()
//                .recipeName("TestRecipe")
//                .category("TestCategory")
//                .recipeInstructions("TestInstructions")
//                .build();
//        Ingredient testIngredientInPantry = Ingredient.builder()
//                .ingredientName("TestIngredientA")
//                .ingredientCategory("TestCategory")
//                .build();
//        Ingredient testIngredientNotInPantry = Ingredient.builder()
//                .ingredientName("TestIngredientB")
//                .ingredientCategory("TestCategory")
//                .build();
//
//        user = userService.create(user.getUsername(), user.getPassword());
//        recipe = recipeService.createRecipe(recipe.getRecipeName(), recipe.getRecipeInstructions(), recipe.getCategory());
//        Long ingredientInPantryId = testIngredientInPantry.getIngredientId();
//        Long ingredientNotInPantryId = testIngredientNotInPantry.getIngredientId();

//        Map<Long, Ingredient> userPantryMap = new HashMap<>();
//        userPantryMap.put(testIngredientInPantry.getIngredientId(), testIngredientInPantry);
//        user.setXuserPantry(userPantryMap);
//        userRepository.save(user);
//
//        Map<Long, Ingredient> recipeIngredientsMap = new HashMap<>();
//        recipeIngredientsMap.put(testIngredientInPantry.getIngredientId(), testIngredientInPantry);
//        recipeIngredientsMap.put(testIngredientNotInPantry.getIngredientId(), testIngredientNotInPantry);
//        recipe.setRecipeIngredients(recipeIngredientsMap);
//        recipeRepository.save(recipe);
//
//        List<Ingredient> groceryList = ingredientService.makeGroceryListFromRecipeIngredientsAndPantryIngredients(user.getUserId(), recipe.getRecipeId());
//
//        assertFalse(groceryList.contains(testIngredientInPantry));
//    }

}

