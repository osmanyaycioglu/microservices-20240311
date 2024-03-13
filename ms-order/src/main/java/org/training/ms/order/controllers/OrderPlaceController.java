package org.training.ms.order.controllers;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.ms.order.controllers.models.PlaceOrderRequest;
import org.training.ms.order.controllers.models.PlaceOrderResponse;

@RestController
@RequestMapping("/api/v1/order/place")
public class OrderPlaceController {

    @PutMapping
    public PlaceOrderResponse placeOrder(PlaceOrderRequest orderRequestParam){
        return null;
    }

    @PostMapping
    public PlaceOrderResponse addOrder(PlaceOrderRequest orderRequestParam){
        return null;
    }

}
