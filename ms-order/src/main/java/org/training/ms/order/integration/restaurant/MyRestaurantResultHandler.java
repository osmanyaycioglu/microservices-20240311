package org.training.ms.order.integration.restaurant;

import org.training.restaurant.api.models.StartResponse;

import java.util.function.Predicate;

public class MyRestaurantResultHandler implements Predicate<StartResponse> {

    @Override
    public boolean test(final StartResponse startResponseParam) {
        System.out.println("Result handler devrede");
        return false;
    }
}
