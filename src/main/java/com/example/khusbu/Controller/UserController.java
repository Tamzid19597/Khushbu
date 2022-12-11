package com.example.khusbu.Controller;

import com.example.khusbu.Model.User;
import com.example.khusbu.Repository.UserRepository;
import com.example.khusbu.Service.DealService;
import com.example.khusbu.Service.ProductService;
import com.example.khusbu.Service.ProfileService;
import com.example.khusbu.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@AllArgsConstructor

public class UserController {
    private  final UserRepository userRepository;
    private final UserService userService;
    private final ProfileService profileService;
    private final ProductService productService;
    private final DealService dealService;

    @GetMapping("/signup")
    public String getSignup(Model model){
        model.addAttribute("user",new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String postSignup(Model model, User user){
        userService.addUser(user);
        model.addAttribute("user",new User());
        return "login";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("user",new User());
        return "login";
    }

    @PostMapping("/login")
    public RedirectView postLogin(Model model,User user){
        if (userService.loginValidate(user)){
            profileService.setProfileUser(user);
            return new RedirectView("http://localhost:8080/home");
        }
        model.addAttribute("user",new User());
        return new RedirectView("http://localhost:8080/login");
    }

    @GetMapping("/mydeal")
    public String myDeal(Model model){
        if (profileService.getProfileUser()!=null){
            model.addAttribute("Deals",dealService.getDeals(profileService.getProfileUser()));
            return "myDeal";
        }
        model.addAttribute("user",new User());
        return "login";
    }


}
