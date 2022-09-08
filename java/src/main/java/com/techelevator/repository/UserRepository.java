package com.techelevator.repository;
import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;
import com.techelevator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByUserId(Long id);

    //Map<Long, Ingredient> findAllIngredientsByUserId(Long userId);

    //Map<Long, Recipe> findAllRecipesByUserId(Long userId);

    List<User> findAll();
}
