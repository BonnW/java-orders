package com.burahan.restorders.repository;

import com.burahan.restorders.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>
{
    @Query(value = "SELECT c.custname, o.ordnum FROM customer c, orders o WHERE c.custcode = o.custcode ORDER BY c.custname", nativeQuery = true)
    List<Object[]> getCustomerOrders();

    @Query(value = "SELECT custcode FROM customer WHERE custname = :name", nativeQuery = true)
    List<Object[]> getIdWithName(@Param("name") String name);

    @Query(value = "SELECT c.custname, o.ordnum, o.ordamount FROM customer c, orders o WHERE c.custcode = o.custcode AND c.custname = :name", nativeQuery = true)
    List<Object[]> getOrdersFromCustomer(@Param("name") String name);
}

//    WHERE custcode = (SELECT custcode FROM customer WHERE custname = :name))", nativeQuery = true)