package org.training.kafka.msnotify;

import lombok.Data;

@Data
public class NotifyMessage {
    private String dest;
    private String msg;
    private Long validPeriod;
}
