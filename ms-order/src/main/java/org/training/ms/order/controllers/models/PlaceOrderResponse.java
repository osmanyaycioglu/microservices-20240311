package org.training.ms.order.controllers.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PlaceOrderResponse {
    private String desc;
    private LocalDateTime deliveryTime;
}
