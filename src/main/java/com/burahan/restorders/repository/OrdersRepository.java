package com.burahan.restorders.repository;

import com.burahan.restorders.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long>
{
    // Works in sqlitestudio. Trying out string concat method
    @Query(value = "SELECT * FROM orders WHERE custcode = " + id, nativeQuery = true)
    List<Object[]> getOrdersByCustId(@Param("id") long id);
}
