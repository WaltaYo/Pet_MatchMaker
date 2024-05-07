package com.petmatchmaking.Controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.petmatchmaking.Dtos.AnswerDto;
import com.petmatchmaking.Dtos.QuestionDto;
import com.petmatchmaking.Dtos.ScoreboardDto;
import com.petmatchmaking.Models.ScoreboardModel;
import com.petmatchmaking.Models.UserModel;
import com.petmatchmaking.Services.AnswerService;
import com.petmatchmaking.Services.QuestionService;
import com.petmatchmaking.Services.ScoreboardService;
import com.petmatchmaking.Services.UserService;

import jakarta.annotation.Resource;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class HomeController extends BaseController {

    @Resource
    private final UserService userService;

    @Resource
    private final ScoreboardService scoreboardService;

    @Resource 
    private final QuestionService questionService;

    @Resource 
    private final AnswerService answerService;

    public HomeController(UserService userService, 
                         ScoreboardService scoreboardService,
                         QuestionService questionService,
                         AnswerService answerService) {
        this.userService = userService;
        this.scoreboardService = scoreboardService;
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @GetMapping
    public String getIndex() {
        return "home/index";
    }

    @GetMapping("/quiz/")
    public String getQuiz(Model model, HttpServletRequest request, HttpServletResponse response) {
        if (isUserLoggedIn(request)) {
            return "redirect:/createlogin";
        }
        Integer questionOrder = 0;
        String order = getCookieValue("questionOrder", request);
        if (order.length() > 0) {
            questionOrder = Integer.parseInt(order);
        }
        questionOrder++;
        writeCookieValue("questionOrder", questionOrder.toString(), response);

        Iterable<ScoreboardDto> score = scoreboardService.findAllByUserId(getUserId(request));
        model.addAttribute("scoreboard", score);
        
        ArrayList<QuestionDto> questions = questionService.findAllDtos();
        QuestionDto question = questions.get( (questionOrder-1));
        model.addAttribute("question", question);
        return "home/quiz";
    }

    @PostMapping("/question")
    public String postMethodName(@RequestBody QuestionDto questions) {
        // for(AnswerDto dto : questions.getAnswerDto()){
        //     ScoreboardModel score = scoreboardService.findById()
        // }
        return "redirect:/quiz";
    }
    

    @GetMapping("/resource")
    public String getResource() {
        return "home/resource";
    }

    @GetMapping("/aboutus")
    public String getAboutUs() {
        return "home/aboutus";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "home/createlogin";
    }

    @PostMapping("/createlogin")
    public String loginUser(@RequestParam String userId, @RequestParam String password, HttpServletResponse response) {
        UserModel user = userService.findByUserId(userId);
        if (user != null && password.equals(user.getPassword())) {
            Cookie userIdCookie = new Cookie("Id", user.getId().toString());
            Cookie userNameCookie = new Cookie("username", user.getName());
            response.addCookie(userNameCookie);
            response.addCookie(userIdCookie);
            return "redirect:/";
        }
        return "redirect:/createlogin";
    }

    @GetMapping("/logout")
    public String logoutUser(HttpServletResponse response) {
        Cookie userIdCookie = new Cookie("Id", null);
        userIdCookie.setMaxAge(0);
        Cookie userNameCookie = new Cookie("username", null);
        userNameCookie.setMaxAge(0);
        response.addCookie(userNameCookie);
        response.addCookie(userIdCookie);
        return "redirect:/";
    }
}
