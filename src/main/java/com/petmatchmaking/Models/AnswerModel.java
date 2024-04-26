package com.petmatchmaking.Models;

import jakarta.persistence.*;


/**
 * Model class for Answers
 */
@Entity
@Table(name = "t_Answers")
public class AnswerModel {

    @Id
    @GeneratedValue()
    private Long id;

    @Column()
    private String answer;

    /**
     * Default Constructor
     */
    public AnswerModel() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param id
     * @param answer
     */
    public AnswerModel(Long id, String answer) {
        this.id = id;
        this.answer = answer;
    }

    /**
     * Getters and Setters
     */

    /**
     * Method to get Id
     * 
     * @return answer id
     */
    public Long getId() {
        return id;
    }

    // /**
    //  * Method to Set Id
    //  * 
    //  * @param id
    //  */
    // public void setId(Long id) {
    //     id = id;
    // }

    /**
     * Method to Get Answer
     * 
     * @return  answer 
     */
    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "AnswerModel [Id=" + id + ", answer=" + answer + "]";
    }

}
