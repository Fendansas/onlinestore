package com.github.fendansas.onlinestore.controller;

import com.github.fendansas.onlinestore.domain.Product;
import com.github.fendansas.onlinestore.dto.ProductDTO;
import com.github.fendansas.onlinestore.repo.ProductRepo;
import com.github.fendansas.onlinestore.servise.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductsListController {

    static private final Integer SIZE = 5;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductService productService;

    @Autowired
    private ConversionService conversionService;

    @GetMapping("/productslist")
    public String getAllProducts(@RequestParam(required = false, name = "pn") Integer pageNum,
                                 @RequestParam(required = false,
                                         name = "sort") Sort.Direction sortDirection,
                                 @RequestParam(required = false,
                                         name = "fileName") String sortField, Model model) {
        if (pageNum == null) {
            pageNum = Integer.valueOf(0);
        } else {
            pageNum -= 1;
        }
        Page<Product> productPage = productService.getProductPage(pageNum,
                SIZE,
                sortField,
                sortDirection);

        List<ProductDTO> productDTOS = productPage.get().map(p -> conversionService.
                convert(p, ProductDTO.class)).
                collect(Collectors.toList());
        model.addAttribute("products", productDTOS);
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("fieldName", sortField);
        model.addAttribute("sort", sortDirection);
        return "productslist";
    }
}
