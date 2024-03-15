package org.training.ms.order.integration.restaurant;

import org.springframework.cloud.openfeign.FeignClient;
import org.training.restaurant.api.IRestaurantController;

@FeignClient("RESTAURANT")
public interface IRestaurantIntegration extends IRestaurantController {
}
