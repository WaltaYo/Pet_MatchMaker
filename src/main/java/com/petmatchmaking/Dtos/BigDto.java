package com.petmatchmaking.Dtos;

import com.petmatchmaking.Dtos.*;

/**
 * Class that models the data needed for the quiz
 */
public class BigDto {
    private QuestionDto questionDto;
    private ScoreboardDto scoreboardDto;

    /**
     * Default Constructor
     */
    public BigDto() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param questionDto question DTO
     * @param scoreboardDto scoreboard dto
     */
    public BigDto(QuestionDto questionDto, ScoreboardDto scoreboardDto) {
        this.questionDto = questionDto;
        this.scoreboardDto = scoreboardDto;
    }

    /**
     * Method to get the question DTO
     * 
     *  @return question dto
     */
    public QuestionDto getQuestionDto() {
        return questionDto;
    }

    /**
     * Method to set the question DTO
     * 
     * @param questionDto question DTO
     */
    public void setQuestionDto(QuestionDto questionDto) {
        this.questionDto = questionDto;
    }
    /**
     * Method to get the scoreboard dto
     * 
     * @return scoreboard dto
     */
    public ScoreboardDto getScoreboardDto() {
        return scoreboardDto;
    }

    /**
     * Method to set the scoreboard dto
     * 
     * @param scoreboardDto scoreboard dto
     */
    public void setScoreboardDto(ScoreboardDto scoreboardDto) {
        this.scoreboardDto = scoreboardDto;
    }
    
}
