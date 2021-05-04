package com.github.fendansas.onlinestore.servise.impl;

import com.github.fendansas.onlinestore.domain.Product;
import com.github.fendansas.onlinestore.dto.ProductDTO;
import com.github.fendansas.onlinestore.exception.ProductNotFoundException;
import com.github.fendansas.onlinestore.repo.ProductRepo;
import com.github.fendansas.onlinestore.servise.ProductService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JPAProductService implements ProductService, InitializingBean {
    @Autowired
    private ProductRepo repo;

    @Override
    public List<Product> getProducts() {
        return repo.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return repo.getOne(id);
    }

    @Override
    public void saveProduct(Product product) {
        repo.save(product);
    }

    //продукт и количество продуктов в заказе.
    //Убеждаемся что > 0 и что количесство в заказе => кол-во на складе
    @Override
    public Boolean isProductInStock(Product product, Integer quantityInOrder) {
        if (product.getInStockQuantity() > 0 && product.getInStockQuantity() >= quantityInOrder) {
            return true;
        }
        return false;
    }

    @Override
    public Page<Product> getProductPage(Integer pageNum,
                                        Integer size,
                                        String fieldName,
                                        Sort.Direction direction) {
        Pageable pagable;
        if (fieldName != null) {
            if (direction == null) {
                direction = Sort.Direction.ASC;
            }
            pagable = PageRequest.of(pageNum, size, direction, fieldName);
        } else {
            pagable = PageRequest.of(pageNum, size);
        }
        return repo.findAll(pagable);
    }

    @Override
    public void edit(ProductDTO productDTO) {
        Product findById = repo.findById(productDTO.getId())
                .orElseThrow(() -> new ProductNotFoundException());
        findById.setName(productDTO.getName());
        findById.setDescription(productDTO.getDescription());
        findById.setPrice(productDTO.getPrice());
        findById.setInStockQuantity(productDTO.getInStockQuantity());

        repo.save(findById);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
