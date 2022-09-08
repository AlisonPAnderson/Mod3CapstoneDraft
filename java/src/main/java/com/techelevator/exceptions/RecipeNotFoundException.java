package com.techelevator.exceptions;

public class RecipeNotFoundException extends Exception {

    public RecipeNotFoundException() {
        super("Recipe not found");
    }
}

