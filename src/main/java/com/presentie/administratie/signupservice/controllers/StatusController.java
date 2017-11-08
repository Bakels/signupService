package com.presentie.administratie.signupservice.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.presentie.administratie.signupservice.model.Status;
import com.presentie.administratie.signupservice.model.StatusTimeModel;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/status")
@RestController
public class StatusController {

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
}
