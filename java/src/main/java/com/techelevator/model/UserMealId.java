package com.techelevator.model;


import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserMealId implements Serializable {
    private static final long serialVersionUID = -3026351110637006139L;
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "meal_id", nullable = false)
    private Integer mealId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserMealId entity = (UserMealId) o;
        return Objects.equals(this.mealId, entity.mealId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealId, userId);
    }

}