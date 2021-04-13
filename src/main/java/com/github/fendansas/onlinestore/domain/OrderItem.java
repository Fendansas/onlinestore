package com.github.fendansas.onlinestore.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "price")
    private BigDecimal price;

    @Positive
    @Column(nullable = false, name = "quantity")
    private Integer quantity;

    @OneToOne
    private Product product;

    @ManyToOne

    private UserOrder userOrder;

    public OrderItem(BigDecimal price, @Positive Integer quantity, Product product) {
        this.price = price;
        this.quantity = quantity;
        this.product = product;
    }


}
