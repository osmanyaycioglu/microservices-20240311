package org.training.ms.order.controllers.models;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PlaceOrderRequest {
    @NotNull
    @NotEmpty
    @NotBlank
    private String orderId; // null ""  "   "
    @NotBlank
    @Size(min = 10,max = 11)
    private String phoneNumber;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @Size(min = 1,max = 10)
    private List<MealOrder> orders;
    private String note;
    @FutureOrPresent
    private LocalDateTime orderDate;

}
