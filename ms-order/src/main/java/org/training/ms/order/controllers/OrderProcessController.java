package org.training.ms.order.controllers;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;
import org.training.ms.order.controllers.models.PlaceOrderRequest;
import org.training.ms.order.controllers.models.PlaceOrderResponse;
import org.training.ms.order.controllers.models.Response;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/order/process")
@Valid
public class OrderProcessController {

    @PostMapping("/place")
    public PlaceOrderResponse placeOrder(@Valid @RequestBody PlaceOrderRequest orderRequestParam) {
        return PlaceOrderResponse.builder()
                                 .withDeliveryTimeParam(LocalDateTime.now()
                                                                     .plusMinutes(30))
                                 .withDescParam("Başarı ile oluşturuldu")
                                 .build();
    }

    @PostMapping("/add")
    public PlaceOrderResponse addOrder(@Valid @RequestBody PlaceOrderRequest orderRequestParam) {
        return null;
    }

    // GET -> /api/v1/order/process/remove?oid=1
    @GetMapping("/cancel")
    public String canccelOrder(@NotNull @RequestParam("oid") Long orderId) {
        return "Order Cancelled : " + orderId;
    }

    // GET -> /api/v1/order/process/pause/1001/dontwant
    @GetMapping("/pause/{abc}/{reason}")
    public String pauseOrder(@NotNull @PathVariable("abc") Long orderId,
                             @NotBlank @PathVariable String reason) {
        return "Order paused : " + orderId + " reason : " + reason;
    }

}
