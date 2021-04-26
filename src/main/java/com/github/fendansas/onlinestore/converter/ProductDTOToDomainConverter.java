package com.github.fendansas.onlinestore.converter;

import com.github.fendansas.onlinestore.domain.Product;
import com.github.fendansas.onlinestore.dto.ProductDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductDTOToDomainConverter implements Converter<ProductDTO, Product> {

    @Override
    public Product convert(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setInStockQuantity(productDTO.getInStockQuantity());
        return product;
    }
}
