package com.petmatchmaking.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.petmatchmaking.Models.UserModel;
import com.petmatchmaking.Services.UserService;

import jakarta.annotation.Resource;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HomeController extends BaseController {

    @Resource
    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getIndex() {
        return "home/index";
    }

    @GetMapping("/quiz/")
    public String getQuiz(Model model, HttpServletRequest request) {
        if(isUserLoggedIn(request)){
            return "redirect:/login";
        }
        int questionOrder = 0;
        String order = getCookieValue("questionOrder", request);
        if(order.length()>0)
        {
           questionOrder = Integer.parseInt(order); 
        }
        
        return "home/quiz";
    }

    @GetMapping("/resource")
    public String getResource() {
        return "home/resource";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "home/login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String userId, @RequestParam String password, HttpServletResponse response) {
        UserModel user = userService.findByUserId(userId);
        if (user != null && password.equals(user.getPassword())) {
            Cookie userIdCookie = new Cookie("Id", user.getId().toString());
            Cookie userNameCookie = new Cookie("username", user.getName());
            response.addCookie(userNameCookie);
            response.addCookie(userIdCookie);
            return "redirect:/";
        }
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logoutUser(HttpServletResponse response){
        Cookie userIdCookie = new Cookie("Id", null);
        userIdCookie.setMaxAge(0);
        Cookie userNameCookie = new Cookie("username", null);
        userNameCookie.setMaxAge(0);
        response.addCookie(userNameCookie);
        response.addCookie(userIdCookie);
        return "redirect:/";
    }
}
