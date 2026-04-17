package com.chude2.chude2.service;

import com.chude2.chude2.entity.UserEntity;
import com.chude2.chude2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserName(username);
        if (userEntity == null){
            throw new UsernameNotFoundException("User not found!");
        }
        UserEntity user = new UserEntity(userEntity.getId() ,userEntity.getUserName(), userEntity.getPassword(), userEntity.getStatus());
        return user;
    }
}
