package com.chude2.chude2.service;

import com.chude2.chude2.entity.CustomerRequirementEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerRequirementService {

    //lấy ds nhu cầu
    public List<CustomerRequirementEntity> findAll(){
        return List.of();
    }

    //lưu nhu cầu
    @Transactional
    public CustomerRequirementEntity save(CustomerRequirementEntity customerRequirementEntity) {
        return customerRequirementEntity;
    }

    //xóa nhu cầu
    @Transactional
    public void deleteList(List<Long> ids) {

    }
}
