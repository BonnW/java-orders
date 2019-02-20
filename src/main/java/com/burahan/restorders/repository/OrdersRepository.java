package com.burahan.restorders.repository;

import com.burahan.restorders.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long>
{
}
