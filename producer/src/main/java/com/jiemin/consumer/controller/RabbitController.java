package com.jiemin.consumer.controller;

import com.alibaba.fastjson.JSON;
import com.jiemin.consumer.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: springbootrabbitmq
 * @description: ${description}
 * @author: jiemin
 * @create: 2018-12-22 07:27
 **/
@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    RabbitConfig rabbitConfig;


    @RequestMapping("/msg")
    public Object sendMsg(@RequestParam Map map){
        String data = JSON.toJSONString(map);
        rabbitTemplate.convertAndSend(rabbitConfig.getExchangeName(), rabbitConfig.getRouteKey(), data);
        return "{\"msg\": \"success\"}";
    }


}
