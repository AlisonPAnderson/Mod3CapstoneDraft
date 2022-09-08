package com.techelevator.exceptions;

public class PantryNotFoundException extends Exception {

    public PantryNotFoundException() {
        super("Pantry not found");
    }
}
