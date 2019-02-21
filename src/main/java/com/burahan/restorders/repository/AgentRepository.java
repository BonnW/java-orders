package com.burahan.restorders.repository;

import com.burahan.restorders.models.Agents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgentRepository extends JpaRepository<Agents, Long>
{
    @Query(value = "SELECT a.agentcode, a.agentname, c.custname FROM agents a JOIN customer c WHERE a.agentcode = c.agentcode", nativeQuery = true)
    List<Object[]> findAllAgentsWithCustomers();

    @Query(value = "SELECT a.agentname, o.ordnum, o.orddescription FROM agents a JOIN orders o WHERE a.agentcode = o.agentcode", nativeQuery = true)
    List<Object[]> findAgentsWithOrders();
}
