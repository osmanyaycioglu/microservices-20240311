package org.training.ms.order.integration.restaurant.models;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class StartResponse {
    private LocalDateTime packageFinish;
    private BigDecimal    price;
    private String        desc;

    public StartResponse() {
    }

    @Builder(setterPrefix = "with")
    public StartResponse(final LocalDateTime packageFinish,
                         final BigDecimal price,
                         String desc) {
        this.packageFinish = packageFinish;
        this.price         = price;
        this.desc          = desc;
    }
}
