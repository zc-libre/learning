package com.zc.rabbitmq.controller;

import com.zc.rabbitmq.sender.SimpleSender;
import com.zc.rabbitmq.sender.WorkSender;
import com.zc.rabbitmq.util.R;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author zhao.cheng
 * @date 2020/8/31 16:29
 */
@RestController
@RequestMapping("/rabbit")
@RequiredArgsConstructor
public class RabbitController {

    private final SimpleSender simpleSender;
    private final WorkSender workSender;

    /**
     *简单模式
     * @return /
     * @throws InterruptedException /
     */
    @GetMapping("/simple")
    public R simpleTest() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            simpleSender.send();
            TimeUnit.SECONDS.sleep(1);
        }
        return R.ok();
    }

    @GetMapping(value = "/work")
    public R workTest() {
        for(int i = 0;i < 10;i++){
            workSender.send(i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return R.ok();
    }
}
