package org.training.ms.order.controllers.models;

import lombok.Data;

@Data
public class Response<T> {
    private boolean success;
    private int errorCode;
    private int rootError;
    private String desc;
    private T data;

}
