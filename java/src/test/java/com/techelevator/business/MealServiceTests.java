package com.techelevator.business;

import com.techelevator.model.Ingredient;
import com.techelevator.model.Meal;
import com.techelevator.model.Recipe;
import com.techelevator.model.User;
import com.techelevator.repository.IngredientRepository;
import com.techelevator.repository.MealRepository;
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
public class MealServiceTests {

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
    @Autowired
    MealRepository mealRepository;

    @Test
    public void mealIdIsNotNull() {
        Meal meal = Meal.builder()
                .mealName("TestMealName")
                .build();
        meal = mealService.createMeal(meal.getMealName());

        Assertions.assertThat(meal.getMealId()).isNotNull();
    }

    @Test
    public void deletedMealIsNull() {
        Meal meal = Meal.builder()
                .mealName("TestMealName")
                .build();
        meal = mealService.createMeal(meal.getMealName());

        Long testMealId = meal.getMealId();
        mealService.deleteMeal(meal.getMealId());

        Meal testMeal = mealRepository.findByMealId(testMealId);

        Assertions.assertThat(testMeal).isNull();
    }
}

