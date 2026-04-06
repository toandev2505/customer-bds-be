package com.chude2.chude2.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "fullname")
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "status")
    private Integer status;

    @OneToMany(mappedBy = "customer")
    List<CustomerRequirementEntity> requirementList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<CustomerRequirementEntity> getRequirementList() {
        return requirementList;
    }

    public void setRequirementList(List<CustomerRequirementEntity> requirementList) {
        this.requirementList = requirementList;
    }
}
