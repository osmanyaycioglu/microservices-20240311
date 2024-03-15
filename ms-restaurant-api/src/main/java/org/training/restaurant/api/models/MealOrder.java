package org.training.restaurant.api.models;

import lombok.Data;

@Data
public class MealOrder {
    private Double amount;
    private String mealName;
}
