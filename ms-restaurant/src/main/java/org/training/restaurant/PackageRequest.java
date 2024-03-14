package org.training.restaurant;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;

import java.util.List;

@Data
public class PackageRequest {
    @Parameter(description = "order id verilmeli")
    private String orderId;
    private List<MealOrder> meals;
}
