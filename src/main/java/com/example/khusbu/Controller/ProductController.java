package com.example.khusbu.Controller;

import com.example.khusbu.Model.Deal;
import com.example.khusbu.Model.Product;
import com.example.khusbu.Model.User;
import com.example.khusbu.Repository.ProductRepository;
import com.example.khusbu.Service.DealService;
import com.example.khusbu.Service.ProductService;
import com.example.khusbu.Service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.time.Instant;

@Controller
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;
    private final DealService dealService;
    private final ProfileService profileService;
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
    @GetMapping("/product/add")
    public String addProductPage(Model model, Product product){
        model.addAttribute("product",new Product());
        return "addProduct";
    }
    @PostMapping("/product/add")
    public RedirectView addProduct(Model model, Product product){
        productService.addProduct(product);
        return new RedirectView("http://localhost:8080/products");
    }
    @GetMapping("/product/delete/{id}")
    public RedirectView deleteProduct(Model model, @PathVariable String id){
        productService.removeProduct(Integer.parseInt(id));
        return new RedirectView("http://localhost:8080/products");
    }
    @GetMapping("/product/buy/{id}")
    public String userInformation(Model model,@PathVariable String id){
        if (profileService.getProfileUser()!=null){
            model.addAttribute("productId", Long.parseLong(id));
            model.addAttribute("deal", new Deal());
            return "userInfo";
        }

        else{
            model.addAttribute("user", new User());
            return "login";
        }
    }
    @PostMapping("/product/buy/{id}")
    public RedirectView buyProduct(Model model, @PathVariable String id,Deal deal){
        deal.setProductId(productService.getProduct(Long.parseLong(id)).getProductId());
        deal.setProductName(productService.getProduct(Long.parseLong(id)).getProductName());
        deal.setProductPrice(productService.getProduct(Long.parseLong(id)).getProductPrice());
        deal.setOrderTime(Instant.now().toString());
        deal.setStatus("pending");
        dealService.addDeal(deal);
        return new RedirectView("http://localhost:8080/mydeal");
    }
    @GetMapping("/deals")
    public String allDeals(Model model){
        model.addAttribute("Deals",dealService.getAllDeals());
        return "allDeals";
    }
    @GetMapping("/deals/{id}")
    public String editDeals(Model model,@PathVariable String id){
        dealService.getDeal(Long.parseLong(id)).setStatus("Delivered");
        dealService.addDeal((dealService.getDeal(Long.parseLong(id))));
        model.addAttribute("Deals",dealService.getAllDeals());
        return "allDeals";
    }

}
