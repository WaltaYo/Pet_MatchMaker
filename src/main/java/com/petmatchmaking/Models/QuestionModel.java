package com.petmatchmaking.Models;

import java.util.*;

import jakarta.persistence.*;

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

    @Column(nullable = false)
    private boolean manyAnswers = false;

    @OneToMany(mappedBy = "questionModel", cascade = CascadeType.ALL)
    private Collection<AnswerModel> answers;

    /**
     * Default Constructor
     */
    public QuestionModel() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param question question string
     */
    public QuestionModel(String question, BREOKAEIRJEJRLKAJRLKEJ) { // I broke this to make sure to edit populator and methods
        this.question = question;
        this.answers = new ArrayList<>();
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
     * @return question
     */
    public String getQuestion() {
        return question;
    }

    
    public Collection<AnswerModel> getAnswers() {
        return answers;
    }

    /**
     * Method to set id   //TO BE DELETED LATERRRR
     * 
     * @param id id for this class
     */
    public void setId(Long id) {
        this.id = id;
    }

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
