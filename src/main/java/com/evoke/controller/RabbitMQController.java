package com.evoke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.evoke.model.Employee;
import com.evoke.service.RabbitMQSender;

@RestController
@RequestMapping(value = "/rabbitmq")
public class RabbitMQController {

    @Autowired
    RabbitMQSender rabbitMQSender;


    @PostMapping(value = "/send")
    public String producer(@RequestBody Employee employee) {
        rabbitMQSender.send(employee);

        return "Message sent to the RabbitMQ Successfully";
    }

}

