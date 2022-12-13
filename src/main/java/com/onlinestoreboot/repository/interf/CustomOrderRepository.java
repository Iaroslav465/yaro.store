package com.onlinestoreboot.repository.interf;

import com.onlinestoreboot.model.Order;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface CustomOrderRepository {

    void update(Order order);

    Order getLast(String email);

    BigInteger getLastWeekIncome();

    BigInteger getLastMonthIncome();

}
