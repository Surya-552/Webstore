package com.ecom.webstore.service;

import com.ecom.webstore.model.Category;
import com.ecom.webstore.model.Product;
import com.ecom.webstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    public void addProject(Product product){
        productRepository.save(product);
    }
    public void removeProductById(long id){
        productRepository.deleteById(id);
    }
    public Optional<Product> getProductById(long id){
        return productRepository.findById(id);
    }
    public  List<Product> getAllProductByCategoryId(int id){
        return productRepository.findAllByCategory_Id(id);
    }
}
