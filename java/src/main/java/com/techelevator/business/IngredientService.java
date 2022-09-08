package com.techelevator.business;

import com.techelevator.exceptions.*;
import com.techelevator.model.*;
import com.techelevator.repository.*;
import com.techelevator.util.BasicLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IngredientService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private RecipeService recipeService;
    @Autowired
    UserPantryRepository userPantryRepository;


    public Ingredient createIngredient(String name, String category) {
        Ingredient ingredient = new Ingredient();

        ingredient.setIngredientName(name);
        ingredient.setIngredientCategory(category);

        ingredientRepository.saveAndFlush(ingredient);

        return ingredient;
    }

    public void deleteIngredient(Long ingredientId) {
        Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
        try {
            if (ingredient == null) {
                throw new IngredientNotFoundException();
            } else {
                ingredientRepository.deleteById(ingredientId);
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
    }

    public Ingredient getIngredient(Long ingredientId) {
        Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
        try {
            if (ingredient == null) {
                throw new IngredientNotFoundException();
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return ingredient;
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }



//    public List<Ingredient> deleteIngredientFromUserPantry(Long userId, Long ingredientId) {
//        List<Ingredient> pantry = new ArrayList<>();
//        try {
//            if (userRepository.findByUserId(userId) == null) {
//                throw new UserNotFoundException();
//            } else if (ingredientRepository.findByIngredientId(ingredientId) == null) {
//                throw new IngredientNotFoundException();
//            } else {
//                User user = userRepository.findByUserId(userId);
//                Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
//
//                pantry = user.getPantryStock();
//                pantry.remove(pantry.indexOf(ingredient));
//
//                userRepository.save(user);
//            }
//        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return pantry;
//    }

//    public List<Ingredient> listIngredientsInPantry(Long userId) {
//        List<Ingredient> pantry = new ArrayList<>();
//        List<Ingredient> ingredientsInUserPantry = new ArrayList<>();
//        try {
//            if(userRepository.findByUserId(userId) == null) {
//                throw new UserNotFoundException();
//            } else{
//                User user = userRepository.findByUserId(userId);
//                if (user.getPantryStock() == null) {
//                    throw new PantryNotFoundException();
//                } else {
//                    pantry = user.getPantryStock();
//                    for (Map.Entry<Long, Ingredient> entry : pantry.entrySet()) {
//                        ingredientsInUserPantry.add(entry.getValue());
//                    }
//                }
//            }
//        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return ingredientsInUserPantry;
//    }

//    public List<Ingredient> makeGroceryListFromRecipeIngredientsAndPantryIngredients(Long userId, Long recipeId) {
//        List<Ingredient> groceryList = new ArrayList<>();
//        try {
//            if (userRepository.findByUserId(userId) == null) {
//                throw new UserNotFoundException();
//
//            } else if (recipeRepository.findByRecipeId(recipeId) == null) {
//                throw new RecipeNotFoundException();
//
//            } else {
//                User user = userRepository.findByUserId(userId);
//                Recipe recipe = recipeRepository.findByRecipeId(recipeId);
//
//                if (user.getPantryStock() == null) {
//                    throw new PantryNotFoundException();
//
//                } else if (recipe.getRecipeIngredients().isEmpty() || recipe.getRecipeIngredients() == null) {
//                    throw new RecipeIngredientsNotFoundException();
//                } else {
//                    List<Ingredient> pantry = user.getPantryStock();
//                    List<Ingredient> recipeIngredients = recipe.getRecipeIngredients();
//                   //List<Ingredient> recipeIngredients = recipeService.listIngredientsInRecipe(recipeId);
//
//                    for (Ingredient ingredient : recipeIngredients) {
//                        if (!pantry.contains(ingredient)) {
//                            groceryList.add(ingredient);
//                        }
//                    }
//                }
//            }
//        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return groceryList;
//    }


    //TODO grocery list logic...





    //TODO test getIngredient
    //TODO test getAllIngredients
    //TODO test listIngredientsInUserPantry
    //TODO test listIngredientsInRecipe
}
