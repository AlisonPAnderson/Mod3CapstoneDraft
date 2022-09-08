package com.techelevator.repository;

import com.techelevator.model.UserRecipe;
import com.techelevator.model.UserRecipeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRecipeRepository extends JpaRepository<UserRecipe, UserRecipeId> {
}