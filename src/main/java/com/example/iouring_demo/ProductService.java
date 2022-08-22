package com.example.iouring_demo;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iouring_demo.ProductRecord;
import com.example.iouring_demo.ProductRepository;

@Service
public class ProductService
{
    @Autowired
    private ProductRepository productRepository;
    public List<ProductRecord> getAllProducts()
    {
        List<ProductRecord>productRecords = new ArrayList<>();
        productRepository.findAll().forEach(productRecords::add);
        return productRecords;
    }
    public void addProduct(ProductRecord productRecord)
    {
        productRepository.save(productRecord);
    }
    public List<ProductRecord> searchProducts(String productCode,String productName) {
        List<ProductRecord> products =productRepository.findByProductCodeOrProductName(productCode,productName);
        return products;
    }
    public List<ProductRecord> searchProd(String productCode) {
        List<ProductRecord> products =productRepository.findByProductCode(productCode);
        return products;
    }
}
