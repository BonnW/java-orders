package com.burahan.restorders.repository;

import com.burahan.restorders.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>
{
    @Query(value = "SELECT c.custname, o.ordnum FROM customer c JOIN orders o ON o.custcode = c.custcode ORDER BY c.custname", nativeQuery = true)
    List<Object[]> getCustomerOrders();

    // BUGGED, returns empty JSON
    @Query(value = "SELECT c.custname, o.ordnum FROM customer c JOIN orders o WHERE c.custname = :name AND c.custcode = o.custcode", nativeQuery = true)
    List<Object[]> getOrdersForCustomer(@Param("name") String name);


}

//    WHERE custcode = (SELECT custcode FROM customer WHERE custname = :name))", nativeQuery = true)