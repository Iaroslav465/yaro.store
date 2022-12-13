package com.onlinestoreboot.controller;

import com.onlinestoreboot.converter.CategoryConverter;
import com.onlinestoreboot.converter.ProductConverter;
import com.onlinestoreboot.dto.ProductDto;
import com.onlinestoreboot.service.interf.CategoryService;
import com.onlinestoreboot.service.interf.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Controller responsible for handling homepage-related requests
 */
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final ProductConverter productConverter;
    private final CategoryConverter categoryConverter;

    /**
     * Returns a view of home page
     *
     * @return View
     */
    @GetMapping("/")
    public String getHome() {
        return "home";
    }

    /**
     * Returns a view of catalog with filtered products
     *
     * @param model Spring MVC {@link Model}
     * @param categoryDto Category name
     * @param name Product name
     * @param minPrice Minimum product price
     * @param maxPrice Maximum product price
     * @param brand Product brand
     * @param color Product color
     * @return View
     */
    @GetMapping("/catalog")
    public String getCatalog(Model model,
                             @RequestParam(required = false) String categoryDto,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) Integer minPrice,
                             @RequestParam(required = false) Integer maxPrice,
                             @RequestParam(required = false) String brand,
                             @RequestParam(required = false) String color) {

        model.addAttribute("categories", categoryConverter.convertToListOfDto(categoryService.getAll()));
        List<ProductDto> productsDto;

        Integer localMinPrice = minPrice;
        Integer localMaxPrice = maxPrice;

        if (localMinPrice == null) {
            localMinPrice = 0;
        }

        if (localMaxPrice == null) {
            localMaxPrice = Integer.MAX_VALUE;
        }

        productsDto = productConverter.convertToListOfDto(
                productService.filter(categoryDto, name, localMinPrice, localMaxPrice, brand, color)
        );

        model.addAttribute("products", productsDto);

        return "catalog";
    }

    /**
     * Returns a view of about page
     *
     * @return View
     */
    @GetMapping("/about")
    public String getAbout() {
        return "about";
    }
}
