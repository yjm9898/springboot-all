package com.jiemin.consumer.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springbootrabbitmq
 * @description: rabbit config
 * @author: jiemin
 * @create: 2018-12-22 07:13
 **/
@Data
@Configuration
@Slf4j
public class RabbitConfig {

    @RabbitListener(queues = "write-boot-queue")
    public void rabbitListener(Object obj){
        log.info("rabbit listener msg :{}", obj);
    }


}
