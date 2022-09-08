package com.techelevator.controller;

import com.techelevator.business.IngredientService;
import com.techelevator.business.UserService;
import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/ingredient")
//@PreAuthorize("isAuthenticated()")
public class IngredientController extends IngredientService{
    //This controller handles the Indredient table

    UserService userService;
    IngredientService ingredientService;

    @Autowired
    public IngredientController(UserService userService, IngredientService ingredientService) {
        this.userService = userService;
        this.ingredientService = ingredientService;
    }


    /*--------------------
    createIngredient()
    POST
    PATH: /ingredient/
    --------------------*/
    @PostMapping ("/")
    public void createIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.createIngredient(ingredient.getIngredientName(),ingredient.getIngredientCategory());
    }


    /*--------------------
    editIngredient()
    PUT
    PATH: /ingredient/{ingredient_id}
    --------------------*/
    @PutMapping ("/{ingredientId}")
    public String editIngredient(@PathVariable("ingredientId") Long ingredientId, @RequestBody Ingredient ingredient) {
        return ("Put/edit requests not working yet. However, I acknowledge to have received a put request for /ingredient/" + ingredientId);
    }


    /*--------------------
    deleteIngredient()
    DELETE
    PATH: /ingredient/{ingredient_id}
    --------------------*/
    @DeleteMapping ("/{ingredientId}")
    public void deleteIngredient(@PathVariable("ingredientId") Long ingredientId) {
        ingredientService.deleteIngredient(ingredientId);
    }

    /*--------------------
    getIngredient()
    GET
    PATH: /Ingredient/{Ingredient_id}
    --------------------*/
    @GetMapping("/{ingredientId}")
    public Ingredient getIngredient(@PathVariable("ingredientId") Long ingredientId) {
        return ingredientService.getIngredient(ingredientId);
    }

    /*--------------------
    List listIngredients()
    GET
    PATH: /Ingredient/
    --------------------*/
    @GetMapping("/")
    public List<Ingredient> listIngredients() {
        return ingredientService.getAllIngredients();
    }


    //Friendly reminder that a user's ingredient list is their Pantry, and is handled in userOwnershipController



}




    //old code - may still be needed :)

    /*UserService userService;
    IngredientService ingredientService;

    @Autowired
    public IngredientController(UserService userService, IngredientService ingredientService) {
        this.userService = userService;
        this.ingredientService = ingredientService;
    }

    //Creats an infgredient

    @PostMapping("/ingredient")
    public Ingredient createIngredient(String name, String category) {
        return ingredientService.createIngredient(name, category);
    }*/

    //Edit an ingredient

    //Remove an ingredient


