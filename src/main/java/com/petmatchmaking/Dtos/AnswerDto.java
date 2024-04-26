package com.petmatchmaking.Dtos;

import com.petmatchmaking.Models.AnswerModel;

public class AnswerDto {

    /**
     * Class for the Answer DTO
     */
    private Long id;
    private String answer;

    /**
     * blank constructor
     */
    public AnswerDto() {
    }

    /**
     * DTO parameterized Constructor
     * 
     * @param model
     */
    public AnswerDto(AnswerModel model) {
        this.id = model.getId();
        this.answer = model.getAnswer();
    }

    /**
     * Get Dto id
     * 
     * @return answer id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set Id
     * 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get answer
     * 
     * @return string answer 
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * set an answer
     * 
     * @param answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Method to convert to answer Model
     * 
     * @return an answer dto converted to an answer model
     */
    public AnswerModel convertToModel() {
        AnswerModel answer = new AnswerModel(this.getAnswer());

        return answer;
    }

}
