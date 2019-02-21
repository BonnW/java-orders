package com.burahan.restorders;

import com.burahan.restorders.models.Customer;
import com.burahan.restorders.repository.AgentRepository;
import com.burahan.restorders.repository.CustomerRepository;
import com.burahan.restorders.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = {}, produces = MediaType.APPLICATION_JSON_VALUE)
public class OrdersController
{
    @Autowired
    AgentRepository agentRepo;

    @Autowired
    CustomerRepository custRepo;

    @Autowired
    OrdersRepository orderRepo;

    @GetMapping("/customer")
    public List<Customer> allCust()
    {
        return custRepo.findAll();
    }

    @GetMapping("/customer/order")
    public List<Object[]> getCustomerOrders()
    {
        return custRepo.getCustomerOrders();
    }

    @GetMapping("/customer/name/{name}")
    public List<Object[]> getOrdersFromCustomer(@PathVariable String name)
    {
        // Loop through twice seperately route?
//        List<Object[]> customerid = custRepo.getIdWithName(name);

        return custRepo.getOrdersForCustomer(name);
    }

    @GetMapping("/customer/order/{custcode}")
    public List<Object[]> getOrdersByCustId(@PathVariable long id)
    {
        return orderRepo.getOrdersByCustId(id);
    }

    @GetMapping("/agents")
    public List<Object[]> getAgents()
    {
        return agentRepo.findAllAgentsWithCustomers();
    }
}
