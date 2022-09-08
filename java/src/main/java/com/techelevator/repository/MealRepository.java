package com.techelevator.repository;
import com.techelevator.model.Meal;
import com.techelevator.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    Meal findByMealId(Long mealId);

    //Map<Long, Recipe> findAllRecipesByMealId(Long mealId);


}

