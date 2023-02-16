package com.lh.userservice.controller;

import com.lh.userservice.model.User;
import com.lh.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${pattern.dateformat}")
    private String dataFormat;

    @GetMapping("/now")
    public String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dataFormat));
    }

    @GetMapping(value = "/{id}")
    public User getUserInfo(@PathVariable("id") Integer id) {
        return userService.getUserInfo(id);
    }
}
