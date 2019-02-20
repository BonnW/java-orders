package com.burahan.restorders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long custcode;

    @Column(nullable = false)
    private String custname;

    private String custcity;

    private String grade;

    private double openingamt;

    private double receiveamt;

    private double paymentamt;

    private double outstandingamt;

    private String phone;

    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
    @JsonIgnore
    private long agentcode;
}
