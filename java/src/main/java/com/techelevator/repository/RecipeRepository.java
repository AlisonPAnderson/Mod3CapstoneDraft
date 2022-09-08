package com.techelevator.repository;
import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Recipe findByRecipeId(Long recipeId);

    //List<Ingredient> findAllIngredientsByRecipeId();



}
