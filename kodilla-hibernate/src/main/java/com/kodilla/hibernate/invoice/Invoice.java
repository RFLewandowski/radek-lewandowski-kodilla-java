package com.kodilla.hibernate.invoice;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "INVOICE")
public class Invoice {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    int id;

    @Column(name = "NUMBER")
    String number;

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "invoice",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    List<Item> items = new ArrayList<>();

    public Invoice(String number) {
        this.number = number;
    }
}
