package com.techelevator.repository;

import com.techelevator.model.MealRecipe;
import com.techelevator.model.MealRecipeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRecipeRepository extends JpaRepository<MealRecipe, MealRecipeId> {
}