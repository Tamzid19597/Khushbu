package com.example.khusbu.Controller;

import com.example.khusbu.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class IndexController {
    private  final ProductService productService;
    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("products",productService.getAllProducts());
        return "index";
    }
}
