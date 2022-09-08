package com.techelevator.model;


import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserMealPlanId implements Serializable {
    private static final long serialVersionUID = -565162052245988568L;
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "meal_plan_id", nullable = false)
    private Long mealPlanId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMealPlanId() {
        return mealPlanId;
    }

    public void setMealPlanId(Long mealPlanId) {
        this.mealPlanId = mealPlanId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserMealPlanId entity = (UserMealPlanId) o;
        return Objects.equals(this.mealPlanId, entity.mealPlanId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealPlanId, userId);
    }

}