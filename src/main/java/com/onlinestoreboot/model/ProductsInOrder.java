package com.onlinestoreboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Entity of products_in_orders table
 * Represents the product belonging to the order and its quantity
 */
@Entity
@Table(name = "products_in_orders", schema = "public")
@NoArgsConstructor
@Getter
@Setter
public class ProductsInOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "products_in_order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_upc")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "number_of_products", nullable = false)
    @Min(0)
    private int numberOfProducts;
}
