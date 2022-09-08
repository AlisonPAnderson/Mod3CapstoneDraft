package com.techelevator.repository;

import com.techelevator.model.UserMeal;
import com.techelevator.model.UserMealId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMealRepository extends JpaRepository<UserMeal, UserMealId> {
}