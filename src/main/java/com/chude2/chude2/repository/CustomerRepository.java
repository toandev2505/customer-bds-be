package com.chude2.chude2.repository;

import com.chude2.chude2.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    @Modifying
    @Query("UPDATE CustomerEntity c SET c.status = 0 WHERE c.id IN :ids")
    void softDeleteByIds(@Param("ids") List<Long> ids);
    
    @Modifying
    @Query("UPDATE CustomerEntity c SET c.status = 1 WHERE c.id IN :ids")
    void recoverByIds(@Param("ids") List<Long> ids);
    
    List<CustomerEntity> findAllByStatus(int status);
}
