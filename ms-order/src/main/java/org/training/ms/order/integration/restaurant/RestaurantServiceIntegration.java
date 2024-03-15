package org.training.ms.order.integration.restaurant;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.training.restaurant.api.models.PackageRequest;
import org.training.restaurant.api.models.StartResponse;

@Service
@RequiredArgsConstructor
public class RestaurantServiceIntegration {
    private final IRestaurantIntegration restaurantIntegration;

    @Retry(name = "restaurant-retry")
    @CircuitBreaker(name = "restaurant-cb", fallbackMethod = "startFallback")
    public StartResponse start(PackageRequest packageRequestParam) {
        return restaurantIntegration.start(packageRequestParam);
    }

    public StartResponse startFallback(PackageRequest packageRequestParam,
                                       Exception exceptionParam) {
        return StartResponse.builder()
                            .withDesc("default")
                            .build();
    }

}
