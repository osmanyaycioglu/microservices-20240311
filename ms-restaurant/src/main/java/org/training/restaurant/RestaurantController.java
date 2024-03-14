package org.training.restaurant;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/restaurant/package")
public class RestaurantController {

    @Value("${server.port}")
    private int port;

    @Operation(description = "package start ediliyor burada", summary = "deneme")
    @PostMapping("/start")
    public StartResponse start(@RequestBody PackageRequest packageRequestParam) {
        return StartResponse.builder()
                            .withPackageFinish(LocalDateTime.now()
                                                            .plusMinutes(20))

                            .withPrice(new BigDecimal(100))
                            .withDesc("işlem poru : " + port)
                            .build();
    }

}
