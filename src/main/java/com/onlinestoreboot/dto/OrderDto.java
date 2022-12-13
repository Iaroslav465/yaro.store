package com.onlinestoreboot.dto;

import com.onlinestoreboot.model.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO class of {@link Order} entity
 */
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {

    private Long id;
    private String customerDto;
    private String paymentMethod;
    private String deliveryMethod;
    private String paymentStatus;
    private String orderStatus;
    private String address;
    private Integer total;
    private LocalDateTime dateOfSale;

    private List<ProductsInOrderDto> productsInOrdersDto;

}
