package com.casestudy.casestudi.model.repository.customer;


import com.casestudy.casestudi.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select b from Customer b where b.customerName like %?1%  and b.flag = 1 order by b.customerName ASC  ",nativeQuery = false)
    Page<Customer> findAllByNameBlogContaining(String name, Pageable pageable);
    @Query(value = "select * from customer where flag = 1",nativeQuery = true)
    List<Customer> findAllCustomerList();
}
