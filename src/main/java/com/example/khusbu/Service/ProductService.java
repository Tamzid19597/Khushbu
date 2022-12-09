package com.example.khusbu.Service;

import com.example.khusbu.Model.Product;
import com.example.khusbu.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public void addProduct(Product product){
        productRepository.save(product);
    }
    public void removeProduct(long productId){
        productRepository.delete(productRepository.findById(productId).get());
    }
    public Product getProduct(long id){
        return productRepository.findById(id).get();
    }
}
