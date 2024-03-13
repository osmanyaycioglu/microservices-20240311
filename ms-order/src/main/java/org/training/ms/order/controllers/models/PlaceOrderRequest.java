package org.training.ms.order.controllers.models;

import lombok.Data;

import java.util.List;

@Data
public class PlaceOrderRequest {
    private String orderId;
    private List<MealOrder> orders;
}
