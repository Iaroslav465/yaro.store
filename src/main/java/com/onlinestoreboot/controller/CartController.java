package com.onlinestoreboot.controller;

import com.onlinestoreboot.converter.AddressConverter;
import com.onlinestoreboot.converter.OrderConverter;
import com.onlinestoreboot.dto.OrderDto;
import com.onlinestoreboot.exception.OutOfStockException;
import com.onlinestoreboot.model.Product;
import com.onlinestoreboot.service.interf.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller responsible for handling cart-related requests
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final AddressService addressService;
    private final CustomerService customerService;
    private final OrderService orderService;
    private final ProductService productService;
    private final ProductsInOrderService productsInOrderService;
    private final AddressConverter addressConverter;
    private final OrderConverter orderConverter;

    /**
     * Returns a view of shopping cart
     *
     * @param model Spring MVC {@link Model}
     * @param session HttpSession
     * @return View
     */
    @GetMapping("/cart")
    @SuppressWarnings("unchecked")
    public String getCart(Model model, HttpSession session) {
        if (session.getAttribute("cart") == null) {
            session.setAttribute("cartSize", 0);
        } else {
            model.addAttribute(
                    "productsDtoMap",
                    productService.getProductsFromCart((Map<Long, Integer>) session.getAttribute("cart"))
            );
            model.addAttribute("orderDto", new OrderDto());
            if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
                model.addAttribute("customerDto", customerService.getCurrentUser().getEmail());
                model.addAttribute("addresses",
                        addressConverter.convertToListOfString(
                                addressService.getByCustomerEmail(customerService.getCurrentUser().getEmail())));
            }
        }

        return "cart";
    }

    /**
     * Creates order from shopping cart
     *
     * @param orderDto DTO of order entity
     * @param session HttpSession
     * @return Redirect to view
     */
    @PostMapping("/cart")
    @SuppressWarnings("unchecked")
    public String createOrder(@ModelAttribute("orderDto") OrderDto orderDto, HttpSession session) {
        orderDto.setDateOfSale(LocalDateTime.now());
        orderService.create(orderConverter.convertToEntity(orderDto));
        productsInOrderService.create(orderService.getLast(orderDto.getCustomerDto()),
                (Map<Long, Integer>) session.getAttribute("cart"));
        session.removeAttribute("cart");
        session.setAttribute("cartSize", 0);
        return "redirect:/account/account";
    }

    /**
     * Adds product to shopping cart
     *
     * @param upc Product UPC to add
     * @param session HttpSession
     * @return Redirect to view
     */
    @RequestMapping("/buy")
    @SuppressWarnings("unchecked")
    public String buyProduct(@RequestParam Long upc, HttpSession session) {
        if (session.getAttribute("cart") == null || (int) session.getAttribute("cartSize") == 0) {
            Map<Long, Integer> cart = new HashMap<>();
            if (productService.checkNumberOfProducts(upc, 1)) {
                cart.put(upc, 1);
                session.setAttribute("cart", cart);
                session.setAttribute("cartSize", 1);
            } else {
                Product product = productService.getOne(upc);
                throw new OutOfStockException(product.getInStock(), product.getName(), product.getColor());
            }
        } else {
            Map<Long, Integer> cart = (Map<Long, Integer>) session.getAttribute("cart");
            if (cart.get(upc) != null && productService.checkNumberOfProducts(upc, cart.get(upc) + 1)) {
                cart.merge(upc, 1, Integer::sum);
                session.setAttribute("cart", cart);
                session.setAttribute("cartSize", cart.size());
            } else if (cart.get(upc) == null) {
                cart.put(upc, 1);
                session.setAttribute("cart", cart);
                session.setAttribute("cartSize", cart.size());
            } else {
                Product product = productService.getOne(upc);
                throw new OutOfStockException(product.getInStock(), product.getName(), product.getColor());
            }
        }

        return "redirect:/catalog";
    }

    /**
     * Deletes product from shopping cart
     *
     * @param upc Product UPC to delete
     * @param session HttpSession
     * @return Redirect to view
     */
    @RequestMapping("/delete_from_card")
    @SuppressWarnings("unchecked")
    public String deleteProductFromCart(@RequestParam Long upc, HttpSession session) {
        Map<Long, Integer> cart = (Map<Long, Integer>) session.getAttribute("cart");
        cart.remove(upc);
        session.setAttribute("cart", cart);
        session.setAttribute("cartSize", cart.size());
        return "redirect:/cart/cart";
    }
}
