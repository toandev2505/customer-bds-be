package com.chude2.chude2.api;


import com.chude2.chude2.entity.CustomerEntity;
import com.chude2.chude2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value= "apiOfCustomer")
@CrossOrigin(origins = "*")
public class CustomerAPI {
    @Autowired
    private CustomerService customerService;

    //hiển thị khách hàng có status = 1
    @GetMapping(value= "/api/customer")
    public List<CustomerEntity> show(){
        return customerService.findAll();
    }

    //hiển thị khách hàng có status = 0
    @GetMapping(value= "/api/customer/history")
    public List<CustomerEntity> showHistoryCustomer(){
        return customerService.findAllRemovedCustomer();
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

    //xóa mềm
    @DeleteMapping(value = "/api/customer")
    public void deleteCustomer(@RequestBody List<Long> ids){
        customerService.deleteList(ids);
    }

    //xóa cứng
    @DeleteMapping(value = "/api/customer/history")
    public void deleteHistoryCustomer(@RequestBody List<Long> ids){
        customerService.deleteHistoryList(ids);
    }

    //khôi phục
    @PostMapping(value = "/api/customer/history")
    public void recoverCustomer(@RequestBody List<Long> ids) {customerService.recover(ids);}
}
