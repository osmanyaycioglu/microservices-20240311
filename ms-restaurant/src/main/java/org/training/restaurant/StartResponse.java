package org.training.restaurant;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class StartResponse {
    private LocalDateTime packageFinish;
    private BigDecimal price;

    public StartResponse() {
    }

    @Builder(setterPrefix = "with")
    public StartResponse(final LocalDateTime packageFinish,
                         final BigDecimal price) {
        this.packageFinish = packageFinish;
        this.price         = price;
    }
}
