package com.techelevator.business;

import com.techelevator.exceptions.IngredientNotFoundException;
import com.techelevator.model.Ingredient;
import com.techelevator.model.User;
import com.techelevator.model.UserPantry;
import com.techelevator.repository.IngredientRepository;
import com.techelevator.repository.UserPantryRepository;
import com.techelevator.util.BasicLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserPantryService {


    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    UserPantryRepository userPantryRepository;

    public UserPantry create(Long userId) {
        UserPantry userPantry = new UserPantry();
        userPantry.setUserId(userId);
        userPantryRepository.saveAndFlush(userPantry);
        return userPantry;
    }

    public Map<Long, Ingredient> addIngredientToUserPantry(Long userId, Long ingredientId) {
        Map<Long, Ingredient> userPantryStock = new HashMap<>();
        try {
            if (ingredientRepository.findByIngredientId(ingredientId) == null) {
                throw new IngredientNotFoundException();
            } else {
                userPantryStock.put(ingredientId, ingredientRepository.findByIngredientId(ingredientId));
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return userPantryStock;
    }



//    public List<Ingredient> getIngredientsInUserPantry(Long userId) {
//        List<UserPantry> userPantryList = new ArrayList<>();
//        userPantryList = userPantryRepository.findAllByUserId(userId);
//        List<Ingredient> ingredientsInUserPantry = new ArrayList<>();
//
//        for(UserPantry userPantry: userPantryList) {
//            Ingredient ingredient = ingredientRepository.findByIngredientId(userPantry.getIngredientId());
//            ingredientsInUserPantry.add(ingredient);
//        }
//
//        return ingredientsInUserPantry;
//    }



}
