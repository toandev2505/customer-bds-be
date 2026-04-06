package com.chude2.chude2.api;


import com.chude2.chude2.entity.CustomerEntity;
import com.chude2.chude2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value= "apiOfCustomer")
public class CustomerAPI {
    @Autowired
    private CustomerService customerService;
    @GetMapping(value= "/api/customer")
    public List<CustomerEntity> show(){
        return customerService.findAll();
    }

    @GetMapping(value = "/api/customer/{id}")
    public CustomerEntity showDetail(@PathVariable("id") long id){
        return customerService.findOneById(id);
    }

    @PostMapping(value = "/api/customer")
    public CustomerEntity createCustomer(@RequestBody CustomerEntity customerEntity){
        return customerService.save(customerEntity);
    }

    @PutMapping(value = "/api/customer/{id}")
    public CustomerEntity updateCustomer(@RequestBody CustomerEntity customerEntity, @PathVariable("id") long id){
        customerEntity.setId(id);
        return customerService.save(customerEntity);
    }

    @DeleteMapping(value = "/api/customer")
    public void deleteCustomer(@RequestBody List<Long> ids){
        customerService.deleteList(ids);
    }
}
