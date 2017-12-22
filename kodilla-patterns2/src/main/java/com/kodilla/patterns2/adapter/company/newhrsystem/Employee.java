package com.kodilla.patterns2.adapter.company.newhrsystem;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class Employee {
    final private String peselId;
    final private String firstname;
    final private String lastname;
    final private BigDecimal baseSalary;
}