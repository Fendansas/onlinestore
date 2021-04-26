package com.github.fendansas.onlinestore.controller;

import com.github.fendansas.onlinestore.domain.Product;
import com.github.fendansas.onlinestore.dto.ProductDTO;
import com.github.fendansas.onlinestore.servise.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AddProduct {

    @Autowired
    ProductService productService;

    @Autowired
    ConversionService conversionService;

    @GetMapping("/addProduct")
    String getForm(ProductDTO productDTO, Model model) {
        if (productDTO == null) {
            productDTO = new ProductDTO();
        }
        model.addAttribute("product", productDTO);
        return "addProductView";
    }

    @PostMapping("/addProduct/new")
    String getForm(@Valid ProductDTO productDTO, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("productDTO", productDTO);
            System.out.println("Не коректные данные");
            return "redirect:/addProduct";
        }
        productService.saveProduct(conversionService.convert(productDTO, Product.class));
        return "redirect:/products";
    }
}
