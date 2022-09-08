package com.techelevator.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @Column(name = "meal_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "mp_meal_id")
    private Long mealId;

    @Column(name = "meal_name", nullable = false)
    private String mealName;

    @ManyToMany
    @JoinTable(name="meal_recipe",
            joinColumns =
            @JoinColumn(name="meal_id"),
            inverseJoinColumns =
            @JoinColumn(name="recipe_id"))
    //Map<mealId, Recipe>
    private Map<Long, Recipe> mealRecipes;



}
