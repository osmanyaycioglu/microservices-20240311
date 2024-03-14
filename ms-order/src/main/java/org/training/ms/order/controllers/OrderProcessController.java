package org.training.ms.order.controllers;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.training.ms.order.controllers.models.PlaceOrderRequest;
import org.training.ms.order.controllers.models.PlaceOrderResponse;
import org.training.ms.order.controllers.models.Response;
import org.training.ms.order.integration.restaurant.models.PackageRequest;
import org.training.ms.order.integration.restaurant.models.StartResponse;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/order/process")
@Valid
@RequiredArgsConstructor
public class OrderProcessController {
    private final RestTemplate restTemplate;

    @PostMapping("/place")
    public PlaceOrderResponse placeOrder(@Valid @RequestBody PlaceOrderRequest orderRequestParam) {
        PackageRequest packageRequestLoc = new PackageRequest();
        packageRequestLoc.setMeals(orderRequestParam.getOrders());
        packageRequestLoc.setOrderId(packageRequestLoc.getOrderId());
        StartResponse startResponseLoc = restTemplate.postForObject("http://RESTAURANT/api/v1/restaurant/package/start",
                                                                    packageRequestLoc,
                                                                    StartResponse.class);

        return PlaceOrderResponse.builder()
                                 .withDeliveryTimeParam(startResponseLoc.getPackageFinish())
                                 .withDescParam("Paket hazırlanıyor " + startResponseLoc.getDesc())
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
