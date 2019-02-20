package com.burahan.restorders.repository;

import com.burahan.restorders.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>
{
    @Query(value = "SELECT c.custname, o.ordnum FROM customer c, orders o WHERE c.custcode = o.custcode ORDER BY c.custname", nativeQuery = true)
    List<Object[]> getCustomerOrders();
}
