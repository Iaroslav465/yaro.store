package com.onlinestoreboot.service.impl;

import com.onlinestoreboot.repository.interf.ProductRepository;
import com.onlinestoreboot.repository.interf.ProductsInOrderRepository;
import com.onlinestoreboot.model.Order;
import com.onlinestoreboot.model.Product;
import com.onlinestoreboot.model.ProductsInOrder;
import com.onlinestoreboot.service.interf.ProductsInOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Service responsible for operations on productsInOrders
 */
@Service
@RequiredArgsConstructor
@Log4j2
@Transactional(readOnly = true)
public class ProductsInOrderServiceImpl implements ProductsInOrderService {

    private final ProductsInOrderRepository productsInOrderRepository;
    private final ProductRepository productRepository;

    /**
     * Creates a new order
     *
     * @param order Order entity to be created
     * @param cart Map of product UPCs and its quantity in the cart
     */
    @Override
    @Transactional
    public void create(Order order, Map<Long, Integer> cart) {
        if (order == null) {
            throw new IllegalArgumentException("Order can't be null");
        }

        if (cart == null || cart.size() == 0) {
            throw new IllegalArgumentException("Cart can't be null or empty");
        }

        for (Map.Entry<Long, Integer> entry : cart.entrySet()) {
            Product product = productRepository.getOne(entry.getKey());

            ProductsInOrder productsInOrder = new ProductsInOrder();
            productsInOrder.setOrder(order);
            productsInOrder.setProduct(product);
            productsInOrder.setNumberOfProducts(entry.getValue());

            product.setInStock(product.getInStock() - entry.getValue());
            productRepository.update(product);

            productsInOrderRepository.save(productsInOrder);
            log.info("Product #" + product.getUpc() + " added to order #" + order.getId() + " in the amount of " +
                    productsInOrder.getNumberOfProducts() + " pc(s)");
        }
    }

    /**
     * Returns the productsInOrder by id
     *
     * @param id ID of productsInOrder to get
     * @return {@link ProductsInOrder}
     */
    @Override
    public ProductsInOrder getOne(long id) {
        if (id < 1) {
            throw new IllegalArgumentException("ProductsInOrder id can't be less than 1");
        }

        return productsInOrderRepository.findById(id).orElseThrow();
    }
}
