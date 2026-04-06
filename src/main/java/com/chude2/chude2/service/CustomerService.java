package com.chude2.chude2.service;

import com.chude2.chude2.entity.CustomerEntity;
import com.chude2.chude2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public List<CustomerEntity> findAll(){
        return customerRepository.findAll();
    }
    
    public CustomerEntity findOneById(Long id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    @Transactional
    public CustomerEntity save(CustomerEntity customerEntity) {
        return customerRepository.save(customerEntity);
    }

    @Transactional
    public void deleteList(List<Long> ids){
        customerRepository.deleteAllById(ids);
    }
}
