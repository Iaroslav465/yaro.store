package com.onlinestoreboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * Entity of products table
 */
@Entity
@Table(name = "products", schema = "public")
@NoArgsConstructor
@Getter
@Setter
public class Product implements Serializable {

    @Id
    @Column(name = "product_upc")
    private Long upc;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "name", unique = true, nullable = false)
    @NotBlank
    @Size(min = 3, max = 255)
    private String name;

    @Column(name = "price", nullable = false)
    @Min(0)
    private int price;

    @Column(name = "brand", length = 20, nullable = false)
    @NotBlank
    @Size(min = 2, max = 20)
    private String brand;

    @Column(name = "color", length = 20, nullable = false)
    @NotBlank
    @Size(min = 2, max = 20)
    private String color;

    @Column(name = "weight", nullable = false)
    @Min(0)
    private int weight;

    @Column(name = "height", nullable = false)
    @Min(0)
    private int height;

    @Column(name = "width", nullable = false)
    @Min(0)
    private int width;

    @Column(name = "depth", nullable = false)
    @Min(0)
    private int depth;

    @Column(name = "in_stock", nullable = false)
    @Min(0)
    private int inStock;

    @Column(name = "imagepath", nullable = false)
    @Size(min = 5, max = 255)
    private String imagePath;

    @Column(name = "deleted", nullable = false)
    private boolean deleted;

    @OneToMany(mappedBy = "product",
            cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ProductsInOrder> productsInOrders;

}
