package com.techelevator.controller;

import com.techelevator.business.IngredientService;
import com.techelevator.business.UserService;
import com.techelevator.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class recipe_IngredientController{
//This controller handles join tables related to ingredients in recipes

    /*--------------------
    addIngredientToRecipe()
    POST
    Ingredient/recipe/{ingredient_id}/{recipe_id}
    --------------------*/

    /*--------------------
    removeIngredientFromRecipe()
    DELETE
    ingredient/recipe/{ingredient_id}/{recipe_id}
    --------------------*/

}