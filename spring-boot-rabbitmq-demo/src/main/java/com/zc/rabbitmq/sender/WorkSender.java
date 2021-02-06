package com.zc.rabbitmq.sender;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @author zhao.cheng
 * @date 2020/8/31 16:43
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class WorkSender {

    private final RabbitTemplate rabbitTemplate;
    private static final String QUEUE_NAME = "work.hello";

    public void send(int index) {
        StringBuilder builder = new StringBuilder("Hello");
        int limitIndex = index % 3 + 1;
        for (int i = 0; i < limitIndex; i++) {
            builder.append('.');
        }
        builder.append(index + 1);
        String message = builder.toString();
        rabbitTemplate.convertAndSend(QUEUE_NAME,message);
        log.info(" [x] Sent '{}'", message);
    }
}
