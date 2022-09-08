package com.techelevator.exceptions;

public class RecipeIngredientsNotFoundException extends Exception {

    public RecipeIngredientsNotFoundException() {
        super("Recipe Ingredients not found");
    }
}
