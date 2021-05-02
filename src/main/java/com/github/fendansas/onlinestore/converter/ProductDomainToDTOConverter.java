package com.github.fendansas.onlinestore.converter;


import com.github.fendansas.onlinestore.domain.Product;
import com.github.fendansas.onlinestore.dto.ProductDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductDomainToDTOConverter implements Converter<Product, ProductDTO> {
    @Override
    public ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setInStockQuantity(product.getInStockQuantity());
        return productDTO;
    }
}
