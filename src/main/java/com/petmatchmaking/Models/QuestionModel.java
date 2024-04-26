package com.petmatchmaking.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Class that models the questions
 */
@Entity
@Table(name = "t_Questions")
public class QuestionModel {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 900, nullable = false)
    private String question;

    /**
     * Default Constructor
     */
    public QuestionModel() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param id       question id
     * 
     * @param question question string
     */
    public QuestionModel(Long id, String question) {
        this.id = id;
        this.question = question;
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
     * Method to get question
     * 
     * @return question id
     */
    public String getQuestion() {
        return question;
    }

    // /**
    //  * Method to set id 
    //  * 
    //  * @param id id for this class
    //  */
    // public void setId(Long id) {
    //     this.id = id;
    // }

    // /**
    //  * Method to set question
    //  * 
    //  * @param question
    //  */
    // public void setQuestion(String question) {
    //     this.question = question;
    // }

    /**
     * Override method for toString
     */
    @Override
    public String toString() {
        return "QuestionModel [id=" + id + ", question=" + question + "]";
    }

}
