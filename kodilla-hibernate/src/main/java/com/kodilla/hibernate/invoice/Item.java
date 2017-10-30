package com.kodilla.hibernate.invoice;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ITEM")
public class Item {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    int id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    Product product;

    @Column(name = "PRICE")
    BigDecimal price;

    @Column(name = "QUANTITY")
    int quantity;

    @Column(name = "VALUE")
    BigDecimal value;

    @ManyToOne
    @JoinColumn(name = "INVOICE_ID")
    Invoice invoice;

    public Item(Product product, BigDecimal price, int quantity, BigDecimal value) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.value = value;
    }
}
