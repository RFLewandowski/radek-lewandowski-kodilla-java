package com.kodilla.hibernate.task;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Data
@NoArgsConstructor
@Entity
@Table(name = "TASKS_FINANCIALS")
public class TaskFinancialDetails {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private int id;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "PAID")
    private boolean paid;


    public TaskFinancialDetails(BigDecimal price, boolean paid) {
        this.price = price;
        this.paid = paid;
    }
}