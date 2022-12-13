package com.onlinestoreboot.controller;

import com.onlinestoreboot.converter.CategoryConverter;
import com.onlinestoreboot.converter.OrderConverter;
import com.onlinestoreboot.converter.ProductConverter;
import com.onlinestoreboot.dto.CategoryDto;
import com.onlinestoreboot.dto.OrderDto;
import com.onlinestoreboot.dto.ProductDto;
import com.onlinestoreboot.model.Product;
import com.onlinestoreboot.service.interf.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.format.DateTimeFormatter;

/**
 * Controller responsible for handling administrator-related requests
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final OrderService orderService;
    private final CustomerService customerService;
    private final ProductConverter productConverter;
    private final CategoryConverter categoryConverter;
    private final OrderConverter orderConverter;

    /**
     * Returns a view of administrator's page
     *
     * @return View
     */
    @GetMapping("/admin")
    public String getAdmin() {
        return "admin/admin";
    }

    /**
     * Returns a view of creating product
     *
     * @param model Spring MVC {@link Model}
     * @return View
     */
    @GetMapping("/create_product")
    public String getCreateProduct(Model model) {
        model.addAttribute("productDto", new ProductDto());
        model.addAttribute("categoriesDto", categoryConverter.convertToListOfDto(categoryService.getAll()));
        return "admin/create_product";
    }

    /**
     * Creates product
     *
     * @param productDto DTO of Product entity
     * @return Redirect to view
     */
    @PostMapping("/create_product")
    public String createProduct(@ModelAttribute("productDto") ProductDto productDto) {
        productService.create(productConverter.convertToEntity(productDto));
        return "redirect:/admin/admin";
    }

    /**
     * Returns a view of editing product
     *
     * @param model Spring MVC {@link Model}
     * @param upc UPC of product to edit
     * @return View
     */
    @GetMapping("/edit_product")
    public String getEditProduct(Model model, @RequestParam Long upc) {
        model.addAttribute("productDto", productConverter.convertToDto(productService.getOne(upc)));
        model.addAttribute("categoriesDto", categoryConverter.convertToListOfDto(categoryService.getAll()));
        return "admin/edit_product";
    }

    /**
     * Edits product
     *
     * @param productDto DTO of Product entity
     * @return Redirect to view
     */
    @PostMapping("/edit_product")
    public String editProduct(@ModelAttribute("productDto") ProductDto productDto) {
        productService.update(productConverter.convertToEntity(productDto));
        return "redirect:/catalog";
    }

    /**
     * Returns a view of deleting product
     *
     * @param model Spring MVC {@link Model}
     * @param upc UPC of product to delete
     * @return View
     */
    @GetMapping("/delete_product")
    public String getDeleteProduct(Model model, @RequestParam Long upc) {
        Product product = productService.getOne(upc);
        product.setDeleted(true);
        model.addAttribute("productDto", productConverter.convertToDto(product));
        return "admin/delete_product";
    }

    /**
     * Deletes product
     *
     * @param productDto DTO of Product entity
     * @return Redirect to view
     */
    @PostMapping("/delete_product")
    public String deleteProduct(@ModelAttribute("productDto") ProductDto productDto) {
        productService.update(productConverter.convertToEntity(productDto));
        return "redirect:/catalog";
    }

    /**
     * Returns a view of orders history
     *
     * @param model Spring MVC {@link Model}
     * @return View
     */
    @GetMapping("/orders")
    public String getOrders(Model model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        model.addAttribute("formatter", formatter);
        model.addAttribute("ordersDto", orderConverter.convertToListOfDto(orderService.getAll()));
        return "admin/orders";
    }

    /**
     * Returns a view of changing order status
     *
     * @param model Spring MVC {@link Model}
     * @param id Id of order to change status
     * @return View
     */
    @GetMapping("/change_order_status")
    public String getChangeOrderStatus(Model model, @RequestParam Long id) {
        model.addAttribute("orderDto", orderConverter.convertToDto(orderService.getOne(id)));
        return "admin/change_order_status";
    }

    /**
     * Changes order status
     *
     * @param orderDto DTO of Order entity
     * @return Redirect to view
     */
    @PostMapping("/change_order_status")
    public String changeOrderStatus(@ModelAttribute OrderDto orderDto) {
        orderDto.setDateOfSale(orderService.getOne(orderDto.getId()).getDateOfSale());
        orderService.update(orderConverter.convertToEntity(orderDto));
        return "redirect:/admin/orders";
    }

    /**
     * Returns a view of al categories
     *
     * @param model Spring MVC {@link Model}
     * @return View
     */
    @GetMapping("/categories")
    public String getCategories(Model model) {
        model.addAttribute("categoriesDto", categoryConverter.convertToListOfDto(categoryService.getAll()));
        return "admin/categories";
    }

    /**
     * Returns a view of creating category
     *
     * @param model Spring MVC {@link Model}
     * @return View
     */
    @GetMapping("/create_category")
    public String getCreateCategory(Model model) {
        model.addAttribute("categoryDto", new CategoryDto());
        return "admin/create_category";
    }

    /**
     * Creates category
     *
     * @param categoryDto DTO of Category entity
     * @return Redirect to view
     */
    @PostMapping("/create_category")
    public String createCategory(@ModelAttribute("categoryDto") CategoryDto categoryDto) {
        categoryService.create(categoryConverter.convertToEntity(categoryDto));
        return "redirect:/admin/categories";
    }

    /**
     * Returns a view of editing category
     *
     * @param model Spring MVC {@link Model}
     * @param id Id of category to edit
     * @return View
     */
    @GetMapping("/edit_category")
    public String getEditCategory(Model model, @RequestParam Long id) {
        model.addAttribute("categoryDto", categoryConverter.convertToDto(categoryService.getOne(id)));
        return "admin/edit_category";
    }

    /**
     * Edits category
     *
     * @param categoryDto DTO of Category entity
     * @return Redirect to view
     */
    @PostMapping("/edit_category")
    public String editCategory(@ModelAttribute CategoryDto categoryDto) {
        categoryService.update(categoryConverter.convertToEntity(categoryDto));
        return "redirect:/admin/categories";
    }

    /**
     * Returns a view of deleting category
     *
     * @param model Spring MVC {@link Model}
     * @param id Id of category to delete
     * @return View
     */
    @GetMapping("/delete_category")
    public String getDeleteCategory(Model model, @RequestParam Long id) {
        model.addAttribute("categoryDto", categoryConverter.convertToDto(categoryService.getOne(id)));
        return "admin/delete_category";
    }

    /**
     * Deletes category
     *
     * @param categoryDto DTO of Product entity
     * @return Redirect to view
     */
    @PostMapping("/delete_category")
    public String deleteCategory(@ModelAttribute CategoryDto categoryDto) {
        categoryService.delete(categoryConverter.convertToEntity(categoryDto));
        return "redirect:/admin/categories";
    }

    /**
     * Returns a view of statistics
     *
     * @param model Spring MVC {@link Model}
     * @return View
     */
    @GetMapping("/statistics")
    public String getStatistics(Model model) {
        model.addAttribute("productsStatisticsDto", productService.getTopTenProducts());
        model.addAttribute("customersStatisticsDto", customerService.getTopTenCustomers());
        model.addAttribute("lastWeekIncome", orderService.getLastWeekIncome());
        model.addAttribute("lastMonthIncome", orderService.getLastMonthIncome());
        return "admin/statistics";
    }
}
