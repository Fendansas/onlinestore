package com.github.fendansas.onlinestore.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    final private String name = null;

    @Column(name = "description")
    final private String description = null;

    @NotNull
    @Column(name = "price")
    final private BigDecimal price = new BigDecimal(0);

    @Column(name = "in_stock")
    final private Integer inStock = null;

//    public Product(String name, String description, @NotNull BigDecimal price, Integer inStock) {
//        this.name = name;
//        this.description = description;
//        this.price = price;
//        this.inStock = inStock;
//    }
}
