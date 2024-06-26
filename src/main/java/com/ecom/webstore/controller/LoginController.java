package com.ecom.webstore.controller;

import com.ecom.webstore.global.GlobalData;
import com.ecom.webstore.model.Role;
import com.ecom.webstore.model.User;
import com.ecom.webstore.repository.RoleRepository;
import com.ecom.webstore.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @GetMapping("/login")
    public String login(){
        GlobalData.cart.clear();
        return "login";
    }
    @GetMapping("/register")
    public String registerGet(){
        return "register";
    }
    @PostMapping("/register")
    public String registerPost(@ModelAttribute User user, HttpServletRequest request)throws ServletException{
        String password=user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        List<Role> roles =new ArrayList<>();
        roles.add(roleRepository.findById(2).get());
        user.setRoles(roles);
        userRepository.save(user);
        //System.out.println(user.toString());
        request.login(user.getEmail(),password);
        return "redirect:/";
    }
}
