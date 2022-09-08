package com.techelevator.model;


import javax.persistence.*;

@Entity
@Table(name = "user_meal")
public class UserMeal {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private UserMealId id;

    public UserMealId getId() {
        return id;
    }

    public void setId(UserMealId id) {
        this.id = id;
    }

    //TODO [JPA Buddy] generate columns from DB
}