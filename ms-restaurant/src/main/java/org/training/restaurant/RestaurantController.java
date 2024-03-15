package org.training.restaurant;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.training.restaurant.api.IRestaurantController;
import org.training.restaurant.api.models.PackageRequest;
import org.training.restaurant.api.models.StartResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
public class RestaurantController implements IRestaurantController {

    @Value("${server.port}")
    private int port;

    @Operation(description = "package start ediliyor burada", summary = "deneme")
    public StartResponse start(@RequestBody PackageRequest packageRequestParam) {
        return StartResponse.builder()
                            .withPackageFinish(LocalDateTime.now()
                                                            .plusMinutes(20))

                            .withPrice(new BigDecimal(100))
                            .withDesc("işlem poru : " + port)
                            .build();
    }

}
