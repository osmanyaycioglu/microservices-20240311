package org.training.restaurant;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/restaurant/package")
public class RestaurantController {


    @PostMapping("/start")
    public StartResponse start(@RequestBody PackageRequest packageRequestParam) {
        return StartResponse.builder()
                            .withPackageFinish(LocalDateTime.now()
                                                            .plusMinutes(20))
                            .withPrice(new BigDecimal(100))
                            .build();
    }

}
