package com.chude2.chude2.api;

import com.chude2.chude2.entity.CustomerRequirementEntity;
import com.chude2.chude2.service.CustomerRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "apiOfCustomerRequirement")
public class CustomerRequirementAPI {
    @Autowired
    private CustomerRequirementService customerRequirementService;

    @GetMapping("/api/customer/requirement")
    public List<CustomerRequirementEntity> showList(){
        return customerRequirementService.findAll();
    }

    @PostMapping("/api/customer/requirement")
    public CustomerRequirementEntity saveRequirement(@RequestBody CustomerRequirementEntity customerRequirementEntity) {
        return customerRequirementService.save(customerRequirementEntity);
    }

    @PutMapping(value = "/api/customer/requirement/{id}")
    public CustomerRequirementEntity updateCustomerRequirement(@RequestBody CustomerRequirementEntity customerRequirementEntity,
                                                    @PathVariable("id") long id){
        customerRequirementEntity.setId(id);
        return customerRequirementService.save(customerRequirementEntity);
    }

    @DeleteMapping(value = "/api/customer/requirement")
    public void deleteCustomerRequirementList(@RequestBody List<Long> ids){
        customerRequirementService.deleteList(ids);
    }
    @GetMapping("/api/customer/requirement/{customerId}")
    public List<CustomerRequirementEntity> getByCustomerId(@PathVariable Long customerId) {
        return customerRequirementService.findByCustomerId(customerId);
    }
}
