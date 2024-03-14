package org.training.ms.order.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.training.ms.order.controllers.models.PlaceOrderRequest;
import org.training.ms.order.controllers.models.PlaceOrderResponse;
import org.training.ms.order.integration.restaurant.models.PackageRequest;
import org.training.ms.order.integration.restaurant.models.StartResponse;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/order/place")
@RequiredArgsConstructor
public class OrderPlaceController {
    private final RestTemplate restTemplate;

    @PutMapping
    public PlaceOrderResponse placeOrder(PlaceOrderRequest orderRequestParam) {
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

    @PostMapping
    public PlaceOrderResponse addOrder(PlaceOrderRequest orderRequestParam) {
        return null;
    }

}
