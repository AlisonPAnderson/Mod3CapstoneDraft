package com.techelevator.exceptions;

public class IngredientNotFoundException extends Exception {

    public IngredientNotFoundException() {
        super("Ingredient not found");
    }
}

