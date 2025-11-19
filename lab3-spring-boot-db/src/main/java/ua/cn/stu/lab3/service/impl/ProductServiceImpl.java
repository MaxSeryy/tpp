package ua.cn.stu.lab3.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import ua.cn.stu.lab3.entity.Product;
import ua.cn.stu.lab3.repository.ProductRepository;
import ua.cn.stu.lab3.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        ensureSupplier(product);
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        Product existing = getById(id);
        product.setId(existing.getId());
        ensureSupplier(product);
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    private void ensureSupplier(Product product) {
        if (product.getSupplier() == null) {
            throw new IllegalArgumentException("Product must reference a supplier");
        }
    }
}