package com.petmatchmaking.Controllers;

import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.petmatchmaking.Dtos.QuestionDto;
import com.petmatchmaking.Models.AnswerModel;
import com.petmatchmaking.Models.QuestionModel;
import com.petmatchmaking.Services.QuestionService;

import jakarta.annotation.Resource;



/**
 * Class that models the mapping of the question table
 */
@Controller
@RequestMapping("/questions/")
public class QuestionController {

    @Resource
    private final QuestionService questionService;

    /**
     * Parameterized Constructor
     * 
     * @param questionService question services
     */
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    /**
     * Method to map getting all questions
     * 
     * @return all questions
     */
    @GetMapping
    public Iterable<QuestionModel> getAllQuestions(){
        return questionService.findAll();
    }

    /**
     * Method to get a question by id
     * 
     * @param id question id
     * 
     * @return question
     */
    @GetMapping("{id}")
    public String getQuestion(@PathVariable Long id, Model model){
        QuestionModel questionModel = questionService.findById(id);
        String question=questionModel.getQuestion();
        Iterable<AnswerModel> answers=questionModel.getAnswers();
        // ArrayList<String> answersArray = new ArrayList<String>(); 
        // for(
        //     int i=0; i<Iterables.size(answers);
        //     )
        model.addAttribute("question", question);
        model.addAttribute("answers", answers);
        return "home/quiz";
    }

    /**
     * Method to delete a question
     * 
     * @param id question id
     * 
     * @return if the deletion of the question was successful
     */
    @DeleteMapping("{id}")
    public boolean deleteQuestion(@PathVariable Long id){
        return questionService.deleteQuestion(id);
    
    }

   
    /**
     * Method to add question
     * 
     * @param dto data transfer object for question
     * 
     * @return question added
     */
    @PostMapping
    public QuestionModel addQuestion(@RequestBody QuestionDto dto) {
        QuestionModel questionModel = dto.convertToModel();
        return questionService.saveQuestion(questionModel);
    }

    /**
     * Method to save question
     * 
     * @param dto data transfer object for question
     * 
     * @return question updated
     */
    @PutMapping
    public QuestionModel saveQuestion(@RequestBody QuestionDto dto) {
        QuestionModel questionModel = dto.convertToModel();
        return questionService.saveQuestion(questionModel);
    }
    

    


    
}
