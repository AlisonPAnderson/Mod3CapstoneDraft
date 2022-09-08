package com.techelevator.repository;

import com.techelevator.model.MealPlanMeal;
import com.techelevator.model.MealPlanMealId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealPlanMealRepository extends JpaRepository<MealPlanMeal, MealPlanMealId> {
}