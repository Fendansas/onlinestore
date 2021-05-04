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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductListAdminController {

    static final Integer SIZE = 5;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductService productService;

    @Autowired
    private ConversionService conversionService;

    @GetMapping("/productListAdmin")
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
        return "productListAdmin";
    }

    //Удаление
    @RequestMapping(path = "/deleteproduct/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        productRepo.deleteById(id);
        return "redirect:/productListAdmin";
    }

    @GetMapping("/productListAdmin/edit/{id}")
    // @PreAuthorize("@editUserVouter.checkUserId(authentication,#id)")
    public String editProductForm(@PathVariable Integer id, Model model) {

        model.addAttribute("product", productService.getProductById(id));

        return "editProductView";
    }


    @PostMapping("/productListAdmin/edit/{id}")
    public String editProduct(@PathVariable Integer id,
                              @Valid ProductDTO productDTO,
                              BindingResult br,
                              Model model) {

        if (br.hasErrors()) {
            model.addAttribute("productDTO", productDTO);
            return "redirect:/productListAdmin/edit/{id} ";
        }

        Product product = new Product();
        product.setId(id);
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setInStockQuantity(productDTO.getInStockQuantity());

        productService.edit(productDTO);

        return "redirect:/productListAdmin";
    }



}
