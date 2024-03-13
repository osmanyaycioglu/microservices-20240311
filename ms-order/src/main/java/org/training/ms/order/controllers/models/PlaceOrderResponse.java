package org.training.ms.order.controllers.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

@Data
public class PlaceOrderResponse {
    private String        desc;
    private LocalDateTime deliveryTime;

    public PlaceOrderResponse() {
    }

    @Builder(setterPrefix = "with")
    PlaceOrderResponse(final String descParam,
                       final LocalDateTime deliveryTimeParam) {
        desc         = descParam;
        deliveryTime = deliveryTimeParam;
    }
}
