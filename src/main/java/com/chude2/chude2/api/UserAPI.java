package com.chude2.chude2.api;


import com.chude2.chude2.entity.UserEntity;
import com.chude2.chude2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value= "apiOfUser")
public class UserAPI {
    @Autowired
    private UserService userService;
    @GetMapping(value= "/api/user")
    public List<UserEntity> show(){
        return userService.findAll();
    }

    @GetMapping(value = "/api/user/{id}")
    public UserEntity showDetail(@PathVariable("id") long id){
        return userService.findOneById(id);
    }

    @PostMapping(value = "/api/user")
    public UserEntity createUser(@RequestBody UserEntity userEntity){
        return userService.save(userEntity);
    }

    @PutMapping(value = "/api/user/{id}")
    public UserEntity updateUser(@RequestBody UserEntity userEntity, @PathVariable("id") long id){
        userEntity.setId(id);
        return userService.save(userEntity);
    }

    @DeleteMapping(value = "/api/user")
    public void deleteUser(@RequestBody List<Long> ids){
        userService.deleteList(ids);
    }
}
