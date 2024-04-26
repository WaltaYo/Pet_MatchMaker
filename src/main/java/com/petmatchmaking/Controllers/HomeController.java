package com.petmatchmaking.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
    @GetMapping
    public String getIndex(){
        return "home/index";
    }
    @GetMapping("/quiz")
    public String getQuiz(){
        return "home/quiz";
    }
    @GetMapping("/resource")
    public String getResource(){
        return "home/resource";
    }
}
