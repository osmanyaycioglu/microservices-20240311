package org.training.ms.order.integration.restaurant;

import java.util.function.Predicate;

public class MyRestaurantRetryExceptionHandler implements Predicate<Throwable> {

    @Override
    public boolean test(final Throwable throwableParam) {
        if (throwableParam instanceof IllegalStateException) {
            return true;
        }
        return false;
    }
}
