package com.petmatchmaking.Dtos;

import com.petmatchmaking.Models.QuestionModel;

/**
 * Class that models the question model data transfer object
 */
public class QuestionDto {
     
    private Long id;
    private String question;

    /**
     * Default Constructor
     */
    public QuestionDto() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param model Question Model
     */
    public QuestionDto(QuestionModel model) {
        this.id = model.getId();
        this.question = model.getQuestion();
    }

    /**
     * Method to convert the question data transfer object to a question model
     * 
     * @return a question model
     */
    public QuestionModel convertToModel(){
        QuestionModel question = new QuestionModel(
            this.getQuestion());
            return question;
    }

    /**
     * Method to get the question id
     * 
     * @return question id
     */
    public Long getId() {
        return id;
    }

    /**
     * Method to set the Question id
     * 
     * @param id Question id
     */
    public void setId(Long id) {
        this.id = id;
    }

     /**
     * Method to get the question
     * 
     * @return question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Method to set the question
     * 
     * @return question
     */
    public void setQuestion(String question) {
        this.question = question;
    }
    
    
    
    
}
