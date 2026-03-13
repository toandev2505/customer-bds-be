package com.chude2.chude2.service;

import com.chude2.chude2.entity.UserEntity;
import com.chude2.chude2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
@Autowired
    private UserRepository userRepository;
public List<UserEntity> findAll(){
    List<UserEntity> entities=userRepository.findAll();
    return entities;
}
}
