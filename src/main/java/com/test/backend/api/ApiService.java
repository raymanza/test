package com.test.backend.api;

import com.test.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class ApiService {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    private String topic = "test";

    @GetMapping("/publish/{message}")
    public String message(@PathVariable("message") String message){
        kafkaTemplate.send(topic, message);
        return "Success";
    }

    @GetMapping
    public User test(){
        User response = new User();
        response.setName("Joe");
        response.setAge("40");
        response.setGender("male");
        return response;
    }

}
