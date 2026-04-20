package com.chude2.chude2.service;

import com.chude2.chude2.entity.CustomerRequirementEntity;
import com.chude2.chude2.repository.CustomerRequirementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerRequirementService {

    // 1. Phải khai báo và tiêm Repository vào đây
    @Autowired
    private CustomerRequirementRepository customerRequirementRepository;

    // 2. Lấy danh sách nhu cầu từ DB
    public List<CustomerRequirementEntity> findAll(){
        return customerRequirementRepository.findAll();
    }

    // 3. Lưu nhu cầu vào DB
    @Transactional
    public CustomerRequirementEntity save(CustomerRequirementEntity customerRequirementEntity) {
        return customerRequirementRepository.save(customerRequirementEntity);
    }

    // 4. Xóa các nhu cầu theo danh sách ID
    @Transactional
    public void deleteList(List<Long> ids) {
        customerRequirementRepository.deleteAllById(ids);
    }

    // Logic lấy danh sách nhu cầu của một khách hàng cụ thể
    public List<CustomerRequirementEntity> findByCustomerId(Long customerId) {
        return customerRequirementRepository.findByCustomerId(customerId);
    }
}

