package com.techelevator.controller;

import com.techelevator.business.IngredientService;
import com.techelevator.business.UserService;
import com.techelevator.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userOwnershipController{
    //This controller handles join tables related to user ownership

    //------------------------------PANTRY------------------------------


    /*--------------------
    addIngredientToPantry()
    POST
    /pantry/{user_id}/{ingredient_id}
    --------------------*/


    /*--------------------
    removeIngredientFromPantry()
    DELETE
    pantry/recipe/{user_id}/{ingredient_id}
    --------------------*/


    /*--------------------
    List listUserPantry()
    GET
    pantry/user/{user_id}
    --------------------*/

    //------------------------------INGREDIENT------------------------------

    /*--------------------
    addIngredientToUser()
    PUT
    /ingredient/{user_id}/{ingredient_id}
    --------------------*/

    /*--------------------
    removeIngredientFromUser()
    DELETE
    /ingredient/{user_id}/{ingredient_id}
    --------------------*/


    /*--------------------
    List listUserIngredients()
    GET
    /ingredient/{user_id}/
    --------------------*/

    //------------------------------MEAL------------------------------


    /*--------------------
    addMealToUser()
    POST
    /meal/user/{user_id}
    --------------------*/


    /*--------------------
    removeMealFromUser()
    DELETE
    meal/user/{user_id}
    --------------------*/


    /*--------------------
    LIST displayMyMeals
    GET
    /meal/user/{user_id}
    --------------------*/


    //------------------------------MEAL PLAN------------------------------

    /*--------------------
    addUserToMealPlan()
    PUT
    mealplan/user/{user_id}/{meal_plan_id}
    --------------------*/


    /*--------------------
    removeUserFromMealPlan()
    DELETE
    mealplan/user/{meal_plan_id}/{user_id}
    --------------------*/


    /*--------------------
    LIST displayMyMealPlans()
    GET
    /mealplan/user/{user_id}
    --------------------*/








}