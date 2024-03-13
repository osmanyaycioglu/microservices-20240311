package org.training.ms.order.controllers;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.ms.order.controllers.models.PlaceOrderRequest;
import org.training.ms.order.controllers.models.PlaceOrderResponse;
import org.training.ms.order.controllers.models.Response;

@RestController
@RequestMapping("/api/v1/order/process")
public class OrderProcessController {

    @PostMapping("/place")
    public PlaceOrderResponse placeOrder(PlaceOrderRequest orderRequestParam){
        return null;
    }

    @PostMapping("/add")
    public PlaceOrderResponse addOrder(PlaceOrderRequest orderRequestParam){
        return null;
    }

}
