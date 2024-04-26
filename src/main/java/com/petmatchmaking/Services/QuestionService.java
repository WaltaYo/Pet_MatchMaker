package com.petmatchmaking.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.petmatchmaking.Models.QuestionModel;
import com.petmatchmaking.Repositories.QuestionRepository;

import jakarta.annotation.Resource;

/**
 * Class that models the verification of the repository operations
 */
@Service
public class QuestionService {

    @Resource
    private QuestionRepository questionRepository;

    /**
     * Default Constructor
     */
    public QuestionService() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param questionRepository question repository
     */
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    /**
     * Method to find all questions
     * 
     * @return All questions
     */
    public Iterable<QuestionModel> findAll() {
        Iterable<QuestionModel> questions = new ArrayList<>();
        try {
            questions = questionRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return questions;
    }

    /**
     * Method to find question by ID
     * 
     * @param id
     * 
     * @return
     */
    public QuestionModel findById(Long id){
        QuestionModel question = null;
        try {
            Optional<QuestionModel> optQuestion = questionRepository.findById(id);
            if (optQuestion.isPresent()) {
                question = optQuestion.get();
            }
        } catch (Exception ex) {
           throw ex;
        }
        return question;
    }

    /**
     * Method to delete question by ID
     * 
     * @param id question ID
     * 
     * @return if question was deleted
     */
    public boolean deleteQuestion(Long id){
        boolean result = false;
        try {
            questionRepository.deleteById(id);
            Optional<QuestionModel> optQuestion = questionRepository.findById(id);
            if (!optQuestion.isPresent()) {
                result = true;
            }
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    /**
     * Method to add/update question
     * 
     * @param question the question to add/update
     * 
     * @return the added or updated question
     */
    public QuestionModel saveQuestion (QuestionModel question){
        try {
            question = questionRepository.save(question);
        } catch (Exception ex) {
            throw ex;
        }
        return question;
    }

}
