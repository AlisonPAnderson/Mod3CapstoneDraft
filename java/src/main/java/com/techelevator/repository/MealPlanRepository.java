package com.techelevator.repository;
import com.techelevator.model.Meal;
import com.techelevator.model.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealPlanRepository extends JpaRepository<MealPlan, Long> {

    MealPlan findByMealPlanId(Long id);


}
