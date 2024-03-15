package org.training.restaurant.api.models;

import lombok.Data;

import java.util.List;

@Data
public class PackageRequest {
    private String orderId;
    private List<MealOrder> meals;
}
