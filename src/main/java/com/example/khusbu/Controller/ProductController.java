package com.example.khusbu.Controller;

import com.example.khusbu.Model.Product;
import com.example.khusbu.Repository.ProductRepository;
import com.example.khusbu.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;
    @GetMapping("/products")
    public String getAllProducts(Model model){
        model.addAttribute("products",productService.getAllProducts());
        return "productList";
    }
    @GetMapping("/products/{id}")
    public String getProduct(Model model,@PathVariable long id){
        model.addAttribute("product",productService.getProduct(id));
        return "singleProduct";
    }
    @PostMapping("/product/add")
    public RedirectView addProduct(Model model, Product product){
        productService.addProduct(product);
        return new RedirectView("http://localhost:8080/products");
    }
    @PostMapping("/product/delete/{id}")
    public RedirectView deleteProduct(Model model, @PathVariable Long id){
        productService.removeProduct(id);
        return new RedirectView("http://localhost:8080/products");
    }
}
