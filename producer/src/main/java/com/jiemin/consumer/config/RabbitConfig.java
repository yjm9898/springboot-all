package com.jiemin.consumer.config;

import lombok.Data;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springbootrabbitmq
 * @description: rabbit config
 * @author: jiemin
 * @create: 2018-12-22 07:13
 **/
@Data
@Configuration
public class RabbitConfig {


    private String queueName = "write-boot-queue";
    private String exchangeName = "write-boot-exchange";
    private String routeKey = "write-boot-routekey";


    /**
     * 队列
     * @return
     */
    @Bean
    Queue queue(){
        return new Queue(queueName);
    }

    /**
     * exchange
     * @return
     */
    @Bean
    DirectExchange directExchange(){
        return new DirectExchange(exchangeName);
    }

    /**
     * binding
     * @return
     */
    @Bean
    Binding binding(){
        return BindingBuilder.bind(queue()).to(directExchange()).with(routeKey);
    }

}
