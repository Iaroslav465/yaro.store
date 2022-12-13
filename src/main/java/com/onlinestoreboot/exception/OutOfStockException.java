package com.onlinestoreboot.exception;

import lombok.Getter;

/**
 * Throws if the quantity of products in stock is not sufficient for the operation
 */
@Getter
public class OutOfStockException extends RuntimeException {

    private final String errorCode = "Out of stock";
    private final String errorMessage;

    public OutOfStockException(int inStock, String name, String color) {
        if (inStock == 1) {
            this.errorMessage = String.format("Only %d pc of %s in %s color is left in stock at the moment!",
                    inStock, name, color);
        } else {
            this.errorMessage = String.format("Only %d pcs of %s in %s color are left in stock at the moment!",
                    inStock, name, color);
        }
    }
}
