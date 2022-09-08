package com.techelevator.exceptions;

public class MealNotFoundException extends Exception {

    public MealNotFoundException() {
        super("Meal not found");
    }
}
