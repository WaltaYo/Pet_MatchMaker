package com.petmatchmaking.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petmatchmaking.Dtos.AnswerDto;
import com.petmatchmaking.Models.AnswerModel;
import com.petmatchmaking.Services.AnswerService;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/api/vi/answer/")
public class AnswerController {

    @Resource
    private final AnswerService answerService;

    /**
     * 
     * @param answerService
     */
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    /**
     * Method to get all the Answers
     * 
     * @param answerService
     */
    @GetMapping
    public Iterable<AnswerModel> getAllAnswers() {
        return answerService.findAll();
    }

    /**
     * Method to find answer by id
     * 
     * @param id
     * @return a specific answer by the id given 
     */
    @GetMapping("{id}")
    public AnswerDto getAnswer(@PathVariable Long id) {
        AnswerModel answer = answerService.findById(id);
        AnswerDto dto = new AnswerDto(answer);
        return dto;

    }

    /**
     * Method to delete Answers
     * 
     * @param id
     * @return delete an answer based on the id given
     */
    @DeleteMapping("{id}")
    public boolean deleteAnswer(@PathVariable Long id) {
        return answerService.deleteAnswer(id);
    }

    /**
     * Method to add an Answer
     * 
     * @param answerDto
     * @return 
     */
    @PostMapping
    public AnswerModel addAnswer(@RequestBody AnswerDto answerDto) {
        AnswerModel answer = answerDto.convertToModel();
        return answerService.saveAnswer(answer);

    }

    /**
     * Method to save an Answer
     * 
     * @param answerDto
     * @return
     */
    @PutMapping
    public AnswerModel saveAnswer(@RequestBody AnswerDto answerDto) {
        AnswerModel answer = answerDto.convertToModel();
        return answerService.saveAnswer(answer);
    }

}
