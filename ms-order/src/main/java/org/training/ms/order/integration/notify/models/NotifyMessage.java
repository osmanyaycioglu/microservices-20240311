package org.training.ms.order.integration.notify.models;

import lombok.Builder;
import lombok.Data;

@Data
public class NotifyMessage {
    private String dest;
    private String msg;
    private Long validPeriod;


    public NotifyMessage() {
    }

    @Builder(setterPrefix = "with")
    public NotifyMessage(final String dest,
                         final String msg,
                         final Long validPeriod) {
        this.dest        = dest;
        this.msg         = msg;
        this.validPeriod = validPeriod;
    }
}
