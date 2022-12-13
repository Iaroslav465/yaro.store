package com.onlinestoreboot.service.interf;

import com.onlinestoreboot.model.Order;
import com.onlinestoreboot.model.ProductsInOrder;

import java.util.Map;

/**
 * Service interface responsible for operations on productsInOrders
 */
public interface ProductsInOrderService {

    void create(Order order, Map<Long, Integer> cart);

    ProductsInOrder getOne(long id);
}
