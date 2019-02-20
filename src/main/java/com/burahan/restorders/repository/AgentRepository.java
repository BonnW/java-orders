package com.burahan.restorders.repository;

import com.burahan.restorders.models.Agents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agents, Long>
{
}
