package com.chude2.chude2.service;

import com.chude2.chude2.entity.UserEntity;
import com.chude2.chude2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }
    
    public UserEntity findOneById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    @Transactional
    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Transactional
    public void deleteList(List<Long> ids){
        userRepository.deleteAllById(ids);
    }
}
