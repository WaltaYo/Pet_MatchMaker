package com.petmatchmaking;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.petmatchmaking.Models.AnswerModel;
import com.petmatchmaking.Models.PetModel;
import com.petmatchmaking.Models.QuestionModel;
import com.petmatchmaking.Services.*;

import jakarta.annotation.Resource;

@Component
public class Populator implements CommandLineRunner{
    
    @Resource
    private final UserService userService;

    @Resource
    private final PetService petService;

    @Resource
    private final AnswerService answerService;

    @Resource
    private final QuestionService questionService;

    public Populator(UserService userService, PetService petService, AnswerService answerService,
            QuestionService questionService) {
        this.userService = userService;
        this.petService = petService;
        this.answerService = answerService;
        this.questionService = questionService;
    }
    
    @Override
    public void run(String... args) throws Exception {
        QuestionModel questionModel = new QuestionModel("Are you allergic to any of the following?");
        questionModel.setId(1l);
        questionService.saveQuestion(questionModel);

        AnswerModel answerModel = new AnswerModel("Dogs");
        answerModel.setId(1l);
        answerModel.setQuestionModel(questionModel);
        answerService.saveAnswer(answerModel);

        AnswerModel answerModel2 = new AnswerModel("Kats");
        answerModel2.setId(2l);
        answerModel2.setQuestionModel(questionModel);
        answerService.saveAnswer(answerModel2);

        AnswerModel answerModel3 = new AnswerModel("Rodents");
        answerModel3.setId(3l);
        answerModel3.setQuestionModel(questionModel);
        answerService.saveAnswer(answerModel3);

        AnswerModel answerModel4 = new AnswerModel("Birds");
        answerModel4.setId(4l);
        answerModel4.setQuestionModel(questionModel);
        answerService.saveAnswer(answerModel4);

        AnswerModel answerModel5 = new AnswerModel("Reptiles");
        answerModel5.setId(5l);
        answerModel5.setQuestionModel(questionModel);
        answerService.saveAnswer(answerModel5);

        AnswerModel answerModel6 = new AnswerModel("Nope");
        answerModel6.setId(6l);
        answerModel6.setQuestionModel(questionModel);
        answerService.saveAnswer(answerModel6);

        AnswerModel answerModel7 = new AnswerModel("Everything");
        answerModel7.setId(7l);
        answerModel7.setQuestionModel(questionModel);
        answerService.saveAnswer(answerModel7);

        QuestionModel questionModel2 = new QuestionModel("What kind of domicile does thoust reside ith?");
        questionModel2.setId(2l);
        questionService.saveQuestion(questionModel2);

        AnswerModel answerModel8 = new AnswerModel("House");
        answerModel8.setId(8l);
        answerModel8.setQuestionModel(questionModel2);
        answerService.saveAnswer(answerModel8);

        AnswerModel answerModel9 = new AnswerModel("Love Shack/Apartment");
        answerModel9.setId(9l);
        answerModel9.setQuestionModel(questionModel2);
        answerService.saveAnswer(answerModel9);

        AnswerModel answerModel10 = new AnswerModel("Old McDonald's Place");
        answerModel10.setId(10l);
        answerModel10.setQuestionModel(questionModel2);
        answerService.saveAnswer(answerModel10);

        AnswerModel answerModel11 = new AnswerModel("My domicile is missing");
        answerModel11.setId(11l);
        answerModel11.setQuestionModel(questionModel2);
        answerService.saveAnswer(answerModel11);


        PetModel petModel = new PetModel("Fur Missile");
        petModel.setId(1l);
        petService.savePet(petModel);

        PetModel petModel2 = new PetModel("Kat");
        petModel2.setId(2l);
        petService.savePet(petModel2);

        PetModel petModel3 = new PetModel("Neigh Neighs");
        petModel3.setId(3l);
        petService.savePet(petModel3);

        PetModel petModel4 = new PetModel("Birds");
        petModel4.setId(4l);
        petService.savePet(petModel4);
    }
}
