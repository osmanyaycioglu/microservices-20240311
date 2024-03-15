package org.training.kafka.msnotify;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMessageListener {


    @RabbitListener(queues = "my-queue")
    public void listen(String str) {
        System.out.println("Received : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "sms-queue",durable = "true", autoDelete = "false"),
            exchange = @Exchange(name = "int-message-exch",durable = "true", autoDelete = "false",type = ExchangeTypes.DIRECT),
            key = "sms-message"
    ))
    public void listenSms(String str) {
        System.out.println("Received SMS : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "sms-email",durable = "true", autoDelete = "false"),
            exchange = @Exchange(name = "int-message-exch",durable = "true", autoDelete = "false",type = ExchangeTypes.DIRECT),
            key = "email-message"
    ))
    public void listenEmail(String str) {
        System.out.println("Received email : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "tr-messages",durable = "true", autoDelete = "false"),
            exchange = @Exchange(name = "int-topic-message-exch",durable = "true", autoDelete = "false",type = ExchangeTypes.TOPIC),
            key = "msg.sms.europe.east.tr.#"
    ))
    public void listenTRSMS(String str) {
        System.out.println("Received TR SMS : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "all-messages",durable = "true", autoDelete = "false"),
            exchange = @Exchange(name = "int-topic-message-exch",durable = "true", autoDelete = "false",type = ExchangeTypes.TOPIC),
            key = "msg.#"
    ))
    public void listenAll(String str) {
        System.out.println("Received ALL MSG : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "sms-messages",durable = "true", autoDelete = "false"),
            exchange = @Exchange(name = "int-topic-message-exch",durable = "true", autoDelete = "false",type = ExchangeTypes.TOPIC),
            key = "msg.sms.#"
    ))
    public void listenAllSMSM(String str) {
        System.out.println("Received ALL SMS : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "email-messages",durable = "true", autoDelete = "false"),
            exchange = @Exchange(name = "int-topic-message-exch",durable = "true", autoDelete = "false",type = ExchangeTypes.TOPIC),
            key = "msg.email.#"
    ))
    public void listenAllEmails(String str) {
        System.out.println("Received ALL EMAILs : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "all-europe-messages",durable = "true", autoDelete = "false"),
            exchange = @Exchange(name = "int-topic-message-exch",durable = "true", autoDelete = "false",type = ExchangeTypes.TOPIC),
            key = "msg.*.europe.#"
    ))
    public void listenAllEuropeMSGs(String str) {
        System.out.println("Received ALL Europe MSGs : " + str);
    }

}
