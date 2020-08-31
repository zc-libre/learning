package com.zc.rabbitmq.sender;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @author zhao.cheng
 * @date 2020/8/31 16:21
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class SimpleSender {

    private final RabbitTemplate rabbitTemplate;
    private static final String QUEUE_NAME = "simple.hello";

    public void send() {
        String message = "Hello World";
        rabbitTemplate.convertAndSend(QUEUE_NAME,message);
        log.info(" [x] Sent '{}'", message);
    }

}
