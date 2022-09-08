package com.techelevator.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserPantryId implements Serializable {
    private static final long serialVersionUID = 246402969658579154L;
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "ingredient_id", nullable = false)
    private Integer ingredientId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserPantryId entity = (UserPantryId) o;
        return Objects.equals(this.ingredientId, entity.ingredientId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientId, userId);
    }

}