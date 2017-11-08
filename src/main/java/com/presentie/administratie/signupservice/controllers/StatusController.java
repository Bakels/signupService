package com.presentie.administratie.signupservice.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.presentie.administratie.signupservice.model.StatusTimeModel;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RequestMapping("/api/status")
@RestController
public class StatusController {

    private static final String EXCHANGE_NAME = "topic_logs";

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    @Autowired
    private ObjectMapper mapper;

    @RequestMapping(method = RequestMethod.POST)
    public void updateStatus(@RequestBody StatusTimeModel status) throws JsonProcessingException {

        String serialized = mapper.writeValueAsString(status);

        this.template.convertAndSend(queue.getName(), serialized);
    }

    @RequestMapping(path = "/topic", method = RequestMethod.POST)
    public void updateStatusTopic(@RequestBody StatusTimeModel status) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic");


    }
}
