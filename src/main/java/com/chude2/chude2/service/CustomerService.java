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
    // lấy ds khách hàng có status = 1
    public List<CustomerEntity> findAll(){
        return customerRepository.findAllByStatus(1);
    }

    // lấy ds khách hàng có status = 0
    public List<CustomerEntity> findAllRemovedCustomer(){
        return customerRepository.findAllByStatus(0);
    }
    
    public CustomerEntity findOneById(Long id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    @Transactional
    public CustomerEntity save(CustomerEntity customerEntity) {
        return customerRepository.save(customerEntity);
    }

    //xóa mêm
    @Transactional
    public void deleteList(List<Long> ids){
        //customerRepository.softDeleteByIds(ids);
    }

    //xóa cứng
    @Transactional
    public void deleteHistoryList(List<Long> ids){
        customerRepository.deleteAllById(ids);
    }

    //khôi phục customer
    @Transactional
    public void recover(List<Long> ids) {
        //customerRepository.recoverByIds(ids);
    }
}
