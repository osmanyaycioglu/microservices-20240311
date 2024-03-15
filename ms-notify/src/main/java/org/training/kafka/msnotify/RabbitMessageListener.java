package org.training.kafka.msnotify;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMessageListener {


    @RabbitListener(queues = "my-queue")
    public void listen(String str) {
        System.out.println("Received : " + str);
    }

}
