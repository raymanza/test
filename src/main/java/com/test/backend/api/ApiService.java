package com.test.backend.api;

import com.test.backend.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class ApiService {

    @GetMapping
    public User test(){
        User response = new User();
        response.setName("Joe");
        response.setAge("40");
        response.setGender("male");
        return response;
    }

}
