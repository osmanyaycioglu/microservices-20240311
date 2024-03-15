package org.training.ms.order.controllers;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.training.ms.order.controllers.models.PlaceOrderRequest;
import org.training.ms.order.controllers.models.PlaceOrderResponse;
import org.training.ms.order.integration.restaurant.IRestaurantIntegration;
import org.training.restaurant.api.models.PackageRequest;
import org.training.restaurant.api.models.StartResponse;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/v1/order/process")
@Valid
@RequiredArgsConstructor
public class OrderProcessController {
    private final RestTemplate restTemplate;
    private final EurekaClient eurekaClient;
    private final IRestaurantIntegration restaurantIntegration;
    private       AtomicLong   atomicLong = new AtomicLong();

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

    @PostMapping("/place2")
    public PlaceOrderResponse placeOrder2(@Valid @RequestBody PlaceOrderRequest orderRequestParam) {
        PackageRequest packageRequestLoc = new PackageRequest();
        packageRequestLoc.setMeals(orderRequestParam.getOrders());
        packageRequestLoc.setOrderId(packageRequestLoc.getOrderId());

        RestTemplate restTemplateLoc = new RestTemplate();
        long         lLoc            = atomicLong.incrementAndGet();

        Application        restaurantLoc = eurekaClient.getApplication("RESTAURANT");
        List<InstanceInfo> instancesLoc  = restaurantLoc.getInstances();
        if (instancesLoc != null && instancesLoc.size() > 0) {
            int          index           = (int) (lLoc % instancesLoc.size());
            InstanceInfo instanceInfoLoc = instancesLoc.get(index);
            StartResponse startResponseLoc = restTemplateLoc.postForObject("http://"
                                                                           + instanceInfoLoc.getIPAddr()
                                                                           + ":"
                                                                           + instanceInfoLoc.getPort()
                                                                           + "/api/v1/restaurant/package/start",
                                                                           packageRequestLoc,
                                                                           StartResponse.class);

            return PlaceOrderResponse.builder()
                                     .withDeliveryTimeParam(startResponseLoc.getPackageFinish())
                                     .withDescParam("Paket hazırlanıyor " + startResponseLoc.getDesc())
                                     .build();

        }
        throw new IllegalStateException("microservice e ulaşılamıyor");
    }

    @PostMapping("/place3")
    public PlaceOrderResponse placeOrder3(@Valid @RequestBody PlaceOrderRequest orderRequestParam) {
        PackageRequest packageRequestLoc = new PackageRequest();
        packageRequestLoc.setMeals(orderRequestParam.getOrders());
        packageRequestLoc.setOrderId(packageRequestLoc.getOrderId());
        StartResponse startResponseLoc = restaurantIntegration.start(packageRequestLoc);
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
