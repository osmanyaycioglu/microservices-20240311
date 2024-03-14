package org.training.ms.order.integration.restaurant.models;

import lombok.Data;
import org.training.ms.order.controllers.models.MealOrder;

import java.util.List;

@Data
public class PackageRequest {
    private String          orderId;
    private List<MealOrder> meals;
}
