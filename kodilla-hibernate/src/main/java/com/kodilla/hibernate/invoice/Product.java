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
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @NotNull
    @Column(name = "ID", unique = true)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    List<Item> items = new ArrayList<>();

    public Product(String name) {
        this.name = name;
    }
}
