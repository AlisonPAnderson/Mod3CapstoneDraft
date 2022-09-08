package com.techelevator.repository;

import com.techelevator.model.UserMealPlan;
import com.techelevator.model.UserMealPlanId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMealPlanRepository extends JpaRepository<UserMealPlan, UserMealPlanId> {
}