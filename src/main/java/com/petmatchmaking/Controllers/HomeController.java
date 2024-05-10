package com.petmatchmaking.Controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import com.petmatchmaking.Dtos.AnswerDto;
import com.petmatchmaking.Dtos.QuestionDto;
import com.petmatchmaking.Dtos.ScoreboardDto;
import com.petmatchmaking.Dtos.UserDto;
import com.petmatchmaking.Models.AnswerModel;
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
    public String getIndex(@ModelAttribute("loginUser") UserDto login, Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("isLoggedIn", isUserLoggedIn(request));
        if (isUserLoggedIn(request)){
            model.addAttribute("userId", getUserName(request));
        }
        return "home/index";
    }

    @GetMapping("/quiz")
    public String getQuiz(Model model, HttpServletRequest request, HttpServletResponse response) {
        //Checks user for a valid login
        if (!isUserLoggedIn(request)) {
            return "redirect:/login";
        }
        model.addAttribute("isLoggedIn", isUserLoggedIn(request));
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
        if(questionOrder >= (questions.size()-1)){
            return "redirect:/result";
        }
        
        // ArrayList<QuestionDto> questions = questionService.findAllDtos();
        QuestionDto question = questions.get( (questionOrder-1));
        Boolean[] answers = question.getAnswers();
       
       
         model.addAttribute("question", question);
         model.addAttribute("answers", answers);
       
        return "home/quiz";
    }



    @PostMapping("/question")
     public String postMethodName(@ModelAttribute("question") QuestionDto question, BindingResult result) {
        if(question!=null){
            var a = question;
        }
    //   for(AnswerDto dto : questions.getAnswerDto()){
    //     //     ScoreboardModel score = scoreboardService.findById(dto.getId());
    //     //     AnswerModel model = answerService.findById(dto.getId());
    //     //     if(dto.isSelected()){
    //     //         score.setScore(score.getScore()+dto.);
    //     //     }
    //      }
        return "redirect:/quiz";
    }
    
    @GetMapping("/result")
    public String getResult(){
        return "home/result";
    }

    @GetMapping("/resource")
    public String getResource() {
        return "home/resource";
    }

    @GetMapping("/aboutus")
    public String getAboutUs() {
        return "home/aboutus";
    }

    @GetMapping("/createlogin")
    public String getLogin(Model model) {
        UserDto loginUser = new UserDto();
        model.addAttribute("loginUser", loginUser);
        return "home/createlogin";
    }

    @PostMapping("/createlogin")
    public String loginUser(@ModelAttribute("loginUser") UserDto login, HttpServletResponse response) {
        logout(response);
    UserModel model = login.convertToModel();
    userService.saveUser(model);
        // UserModel user = userService.findByUserId(userId);
            Cookie userIdCookie = new Cookie("Id", model.getId().toString());
            Cookie userNameCookie = new Cookie("username", model.getName());
            response.addCookie(userNameCookie);
            response.addCookie(userIdCookie);
            return "redirect:/";
        // }
        // return "redirect:/createlogin";
    }

    @GetMapping("autologin")
    public String autoLogin(HttpServletResponse response){
        logout(response);
        UserModel user = userService.findById(1l);
            Cookie userIdCookie = new Cookie("Id", user.getId().toString());
            Cookie userNameCookie = new Cookie("username", user.getName());
            response.addCookie(userNameCookie);
            response.addCookie(userIdCookie);
            return "redirect:/";
    }
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    

    @GetMapping("/logout")
    public String logoutUser(HttpServletResponse response) {
        logout(response);
        return "redirect:/";
    }

    private void logout(HttpServletResponse response) {
        Cookie userIdCookie = new Cookie("Id", null);
        userIdCookie.setMaxAge(0);
        Cookie userNameCookie = new Cookie("username", null);
        userNameCookie.setMaxAge(0);
       Cookie order = new Cookie("questionOrder", null);
       order.setMaxAge(0);
        response.addCookie(userNameCookie);
        response.addCookie(userIdCookie);
        response.addCookie(order);
    }

    @GetMapping("/virtualpet")
    public String getVirtualPet() {
        return "home/virtualpet";
    }
    
    @PostMapping("login")
    public String login(@ModelAttribute("loginUser") UserDto login, HttpServletResponse response){
        logout(response);

        String userName = login.getUserId();
        String userPassword = login.getPassword();
        UserModel userModel = userService.findByUserId(userName);

        if( userModel.getUserId() != null && userModel.getPassword().equals(userPassword)){
            Cookie userIdCookie = new Cookie("Id", userModel.getId().toString());
            Cookie userNameCookie = new Cookie("username", userModel.getName());
            response.addCookie(userNameCookie);
            response.addCookie(userIdCookie);
            return "redirect:/";
        } else {
            return "redirect:/login";
        }
 
    }
}