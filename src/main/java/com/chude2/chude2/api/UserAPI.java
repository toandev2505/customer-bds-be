package com.chude2.chude2.api;


import com.chude2.chude2.entity.UserEntity;
import com.chude2.chude2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value= "apiOfUser")
public class UserAPI {
    @Autowired
    private UserService userService;
    @GetMapping(value= "/api/user")
    public List<UserEntity> show(){
        return userService.findAll();
    }

}
