package com.onlinestoreboot.config;

import com.onlinestoreboot.converter.ProductConverter;
import com.onlinestoreboot.repository.interf.*;
import com.onlinestoreboot.service.impl.*;
import com.onlinestoreboot.service.interf.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.Mockito.mock;

@Configuration
public class TestConfig {

    @Bean
    public AddressService addressService() {
        return new AddressServiceImpl(addressRepository(), customerService());
    }

    @Bean
    public CategoryService categoryService() {
        return new CategoryServiceImpl(categoryRepository(), productRepository());
    }

    @Bean
    public CustomerService customerService() {
        return new CustomerServiceImpl(customerRepository(), bCryptPasswordEncoder(), roleService());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(orderRepository());
    }

    @Bean
    public ProductService productService() {
        return new ProductServiceImpl(productRepository(), productConverter());
    }

    @Bean
    public ProductsInOrderService productsInOrderService() {
        return new ProductsInOrderServiceImpl(productsInOrderRepository(), productRepository());
    }

    @Bean
    public RoleService roleService() {
        return new RoleServiceImpl(roleRepository());
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl(customerRepository());
    }

    @Bean
    public AddressRepository addressRepository() {
        return mock(AddressRepository.class);
    }

    @Bean
    public CategoryRepository categoryRepository() {
        return mock(CategoryRepository.class);
    }

    @Bean
    public CustomerRepository customerRepository() {
        return mock(CustomerRepository.class);
    }

    @Bean
    public OrderRepository orderRepository() {
        return mock(OrderRepository.class);
    }

    @Bean
    public ProductRepository productRepository() {
        return mock(ProductRepository.class);
    }

    @Bean
    public ProductsInOrderRepository productsInOrderRepository() {
        return mock(ProductsInOrderRepository.class);
    }

    @Bean
    public RoleRepository roleRepository() {
        return mock(RoleRepository.class);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return mock(BCryptPasswordEncoder.class);
    }

    @Bean
    public ProductConverter productConverter() {
        return mock(ProductConverter.class);
    }
}
