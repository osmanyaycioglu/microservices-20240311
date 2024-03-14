package org.training.restaurant;

import lombok.Data;

import java.util.List;

@Data
public class PackageRequest {
    private String orderId;
    private List<MealOrder> meals;
}
