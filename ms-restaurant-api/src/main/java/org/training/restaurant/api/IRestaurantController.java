package org.training.restaurant.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.training.restaurant.api.models.PackageRequest;
import org.training.restaurant.api.models.StartResponse;

public interface IRestaurantController {

    @PostMapping("/api/v1/restaurant/package/start")
    StartResponse start(@RequestBody PackageRequest packageRequestParam);
}
