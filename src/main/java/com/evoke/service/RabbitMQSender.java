package com.evoke.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.evoke.model.Employee;

@Service
public class RabbitMQSender {

    private final Logger log = LoggerFactory.getLogger(RabbitMQSender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${evoke.rabbitmq.exchange}")
    private String exchange;

    @Value("${evoke.rabbitmq.routingkey}")
    private String routingkey;


    public void send(Employee employee) {
        amqpTemplate.convertAndSend(exchange, routingkey, employee);
        log.info("Message Sent = " + employee);

    }
}
