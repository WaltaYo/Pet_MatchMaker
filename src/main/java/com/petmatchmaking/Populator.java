package com.petmatchmaking;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.petmatchmaking.Repositories.QuestionRepository;
import com.petmatchmaking.Repositories.UserRepository;
import com.petmatchmaking.Services.AnswerService;

import jakarta.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private final AnswerService answerService;

    @Resource
    private final QuestionRepository questionRepository;

    @Resource
    private final UserRepository userRepository;

    public Populator(AnswerService answerService, QuestionRepository questionRepository,
            UserRepository userRepository) {
        this.answerService = answerService;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
    }
    
}
