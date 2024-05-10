package com.petmatchmaking;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.petmatchmaking.Models.*;
import com.petmatchmaking.Services.*;

import jakarta.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private final AnswerService answerService;

    @Resource
    private final QuestionService questionService;

    @Resource
    private final UserService userService;

    @Resource
    private final PetService petService;

    public Populator(AnswerService answerService, QuestionService questionService,
            UserService userService, PetService petService) {
        this.answerService = answerService;
        this.questionService = questionService;
        this.userService = userService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetModel petModel = new PetModel("Dog");
        petModel.setId(1l);
        petService.savePet(petModel);

        PetModel petModel2 = new PetModel("Cat");
        petModel2.setId(2l);
        petService.savePet(petModel2);

        PetModel petModel3 = new PetModel("Farm Animals");
        petModel3.setId(3l);
        petService.savePet(petModel3);

        PetModel petModel4 = new PetModel("Birds");
        petModel4.setId(4l);
        petService.savePet(petModel4);

        PetModel petModel5 = new PetModel("Rodents");
        petModel5.setId(5l);
        petService.savePet(petModel5);

        PetModel petModel6 = new PetModel("Reptiles");
        petModel6.setId(6l);
        petService.savePet(petModel6);

        PetModel petModel7 = new PetModel("Virtual Pet");
        petModel7.setId(7l);
        petService.savePet(petModel7);

        PetModel petModel8 = new PetModel("Amphibians");
        petModel8.setId(8l);
        petService.savePet(petModel8);

        PetModel petModel9 = new PetModel("Fish");
        petModel9.setId(9l);
        petService.savePet(petModel9);

        QuestionModel questionModel = new QuestionModel("Are you allergic to any of the following?", true);
        questionModel.setId(1l);
        questionModel.setQuestionOrder(1.0);
        questionService.saveQuestion(questionModel);

        AnswerModel answerModel = new AnswerModel("Dogs");
        answerModel.setId(1l);
        answerModel.setQuestionModel(questionModel);
        answerService.saveAnswer(answerModel);
        answerModel.setNegativeScore(-1);

        AnswerModel answerModel2 = new AnswerModel("Cats");
        answerModel2.setId(2l);
        answerModel2.setQuestionModel(questionModel);
        answerService.saveAnswer(answerModel2);
        answerModel.setPositiveScore(1);

        AnswerModel answerModel3 = new AnswerModel("Rodents");
        answerModel3.setId(3l);
        answerModel3.setQuestionModel(questionModel);
        answerService.saveAnswer(answerModel3);
        answerModel.setPositiveScore(1);

        AnswerModel answerModel4 = new AnswerModel("Birds");
        answerModel4.setId(4l);
        answerModel4.setQuestionModel(questionModel);
        answerService.saveAnswer(answerModel4);
        answerModel.setPositiveScore(1);

        AnswerModel answerModel5 = new AnswerModel("Reptiles");
        answerModel5.setId(5l);
        answerModel5.setQuestionModel(questionModel);
        answerService.saveAnswer(answerModel5);
        answerModel.setPositiveScore(1);

        AnswerModel answerModel6 = new AnswerModel("Fish");
        answerModel6.setId(6l);
        answerModel6.setQuestionModel(questionModel);
        answerService.saveAnswer(answerModel6);
        answerModel.setPositiveScore(1);

        AnswerModel answerModel7 = new AnswerModel("Farm Animals");
        answerModel7.setId(7l);
        answerModel7.setQuestionModel(questionModel);
        answerService.saveAnswer(answerModel7);
        answerModel.setPositiveScore(1);

        AnswerModel answerModel8 = new AnswerModel("Amphibians");
        answerModel8.setId(8l);
        answerModel8.setQuestionModel(questionModel);
        answerService.saveAnswer(answerModel8);
        answerModel.setPositiveScore(1);

        AnswerModel answerModel9 = new AnswerModel("Nope");
        answerModel9.setId(9l);
        answerModel9.setQuestionModel(questionModel);
        answerService.saveAnswer(answerModel9);
        answerModel.setPositiveScore(1);

        AnswerModel answerModel10 = new AnswerModel("Everything");
        answerModel10.setId(10l);
        answerModel10.setQuestionModel(questionModel);
        answerService.saveAnswer(answerModel10);
        answerModel.setPositiveScore(1);

        QuestionModel questionModel2 = new QuestionModel("What type of residence do you have?", false);
        questionModel2.setId(2l);
        questionModel2.setQuestionOrder(2.0);
        questionService.saveQuestion(questionModel2);
        

        AnswerModel answerModel11 = new AnswerModel("House");
        answerModel11.setId(11l);
        answerModel11.setQuestionModel(questionModel2);
        answerService.saveAnswer(answerModel11);
        answerModel.setPositiveScore(1);

        AnswerModel answerModel12 = new AnswerModel("Apartment");
        answerModel12.setId(12l);
        answerModel12.setQuestionModel(questionModel2);
        answerService.saveAnswer(answerModel12);

        AnswerModel answerModel13 = new AnswerModel("Farm");
        answerModel13.setId(13l);
        answerModel13.setQuestionModel(questionModel2);
        answerService.saveAnswer(answerModel13);

        AnswerModel answerModel14 = new AnswerModel("Homeless");
        answerModel14.setId(14l);
        answerModel14.setQuestionModel(questionModel2);
        answerService.saveAnswer(answerModel14);

        QuestionModel questionModel3 = new QuestionModel("Would you rather?....", false);
        questionModel3.setId(3l);
        questionModel3.setQuestionOrder(3.0);
        questionService.saveQuestion(questionModel3);

        AnswerModel answerModel15 = new AnswerModel("Read a book and cuddle with a pet");
        answerModel15.setId(15l);
        answerModel15.setQuestionModel(questionModel3);
        answerService.saveAnswer(answerModel14);

        AnswerModel answerModel16 = new AnswerModel("Go on a long hike with my pet");
        answerModel16.setId(21l);
        answerModel16.setQuestionModel(questionModel3);
        answerService.saveAnswer(answerModel16);

        AnswerModel answerModel17 = new AnswerModel("Play outside with my pet");
        answerModel17.setId(17l);
        answerModel17.setQuestionModel(questionModel3);
        answerService.saveAnswer(answerModel17);

        AnswerModel answerModel18 = new AnswerModel("Just stare at my pet");
        answerModel18.setId(17l);
        answerModel18.setQuestionModel(questionModel3);
        answerService.saveAnswer(answerModel18);

        QuestionModel questionModel4 = new QuestionModel("Have you owned a pet before?", false);
        questionModel4.setId(4l);
        questionModel4.setQuestionOrder(4.0);
        questionService.saveQuestion(questionModel4);

        AnswerModel answerModel19 = new AnswerModel("Yes, but they all had unfortunate and untimely deaths");
        answerModel19.setId(19l);
        answerModel19.setQuestionModel(questionModel4);
        answerService.saveAnswer(answerModel19);

        AnswerModel answerModel20 = new AnswerModel("Yes, they all lived long lives.");
        answerModel20.setId(20l);
        answerModel20.setQuestionModel(questionModel4);
        answerService.saveAnswer(answerModel20);

        AnswerModel answerModel21 = new AnswerModel("Nope, I will be a first time pet owner.");
        answerModel21.setId(21l);
        answerModel21.setQuestionModel(questionModel4);
        answerService.saveAnswer(answerModel21);

        QuestionModel questionModel5 = new QuestionModel("Can you handle a pet that makes noise?", false);
        questionModel5.setId(5l);
        questionModel5.setQuestionOrder(5.0);
        questionService.saveQuestion(questionModel5);

        AnswerModel answerModel22 = new AnswerModel(
                "YES! I love animals that can sing, talk, bark and alert me of their needs!");
        answerModel22.setId(22l);
        answerModel22.setQuestionModel(questionModel5);
        answerService.saveAnswer(answerModel22);

        AnswerModel answerModel23 = new AnswerModel("Some noise is ok but I have to make sure I won't get evicted!");
        answerModel23.setId(23l);
        answerModel23.setQuestionModel(questionModel5);
        answerService.saveAnswer(answerModel23);

        AnswerModel answerModel24 = new AnswerModel("Nope! The quieter the better!");
        answerModel24.setId(24l);
        answerModel24.setQuestionModel(questionModel5);
        answerService.saveAnswer(answerModel24);

        QuestionModel questionModel6 = new QuestionModel("What diet do you prefer for your pet?", false);
        questionModel6.setId(6l);
        questionModel6.setQuestionOrder(6.0);
        questionService.saveQuestion(questionModel6);

        AnswerModel answerModel25 = new AnswerModel("Carnivore- lets feed it live food.");
        answerModel25.setId(25l);
        answerModel25.setQuestionModel(questionModel6);
        answerService.saveAnswer(answerModel25);

        AnswerModel answerModel26 = new AnswerModel("Herbivore- only plant based diet");
        answerModel26.setId(26l);
        answerModel26.setQuestionModel(questionModel6);
        answerService.saveAnswer(answerModel26);

        AnswerModel answerModel27 = new AnswerModel(" Omnivore- meat and veggies are fine");
        answerModel27.setId(27l);
        answerModel27.setQuestionModel(questionModel6);
        answerService.saveAnswer(answerModel27);

        QuestionModel questionModel7 = new QuestionModel("How do you handle commitment?", false);
        questionModel7.setId(7l);
        questionModel7.setQuestionOrder(7.0);
        questionService.saveQuestion(questionModel7);

        AnswerModel answerModel28 = new AnswerModel("I want my forever boo!");
        answerModel28.setId(28l);
        answerModel28.setQuestionModel(questionModel7);
        answerService.saveAnswer(answerModel28);

        AnswerModel answerModel29 = new AnswerModel("Shorter the better.");
        answerModel29.setId(29l);
        answerModel29.setQuestionModel(questionModel7);
        answerService.saveAnswer(answerModel29);

        AnswerModel answerModel30 = new AnswerModel("Just want to play the field.");
        answerModel30.setId(30l);
        answerModel30.setQuestionModel(questionModel7);
        answerService.saveAnswer(answerModel30);

        QuestionModel questionModel8 = new QuestionModel("What is your work vibe?", false);
        questionModel8.setId(8l);
        questionModel8.setQuestionOrder(8.0);
        questionService.saveQuestion(questionModel8);

        AnswerModel answerModel31 = new AnswerModel("I love to work as a team member");
        answerModel31.setId(31l);
        answerModel31.setQuestionModel(questionModel8);
        answerService.saveAnswer(answerModel31);

        AnswerModel answerModel32 = new AnswerModel("I like to work independent with minimal interuptions");
        answerModel32.setId(32l);
        answerModel32.setQuestionModel(questionModel8);
        answerService.saveAnswer(answerModel32);

        AnswerModel answerModel33 = new AnswerModel("I work in complete chaos");
        answerModel33.setId(33l);
        answerModel33.setQuestionModel(questionModel8);
        answerService.saveAnswer(answerModel33);

        QuestionModel questionModel9 = new QuestionModel("What kind of lifestyle do you maintain?", false);
        questionModel9.setId(9l);
        questionModel9.setQuestionOrder(9.0);
        questionService.saveQuestion(questionModel9);

        AnswerModel answerModel34 = new AnswerModel("High maintenance - only want the absolute best and expensive things for myself");
        answerModel34.setId(34l);
        answerModel34.setQuestionModel(questionModel9);
        answerService.saveAnswer(answerModel34);

        AnswerModel answerModel35 = new AnswerModel("Medium- I like luxury where I can but I can be easy going ");
        answerModel35.setId(35l);
        answerModel35.setQuestionModel(questionModel9);
        answerService.saveAnswer(answerModel35);

        AnswerModel answerModel36 = new AnswerModel("Low- I love a low budget");
        answerModel36.setId(36l);
        answerModel36.setQuestionModel(questionModel9);
        answerService.saveAnswer(answerModel36);

        QuestionModel questionModel10 = new QuestionModel("Can you take care of yourself?", false);
        questionModel10.setId(10l);
        questionModel10.setQuestionOrder(10.0);
        questionService.saveQuestion(questionModel10);

        AnswerModel answerModel37 = new AnswerModel("Yes, but adulting is hard");
        answerModel37.setId(37l);
        answerModel37.setQuestionModel(questionModel10);
        answerService.saveAnswer(answerModel37);

        AnswerModel answerModel38 = new AnswerModel("No, I'm still a child and need a parent to help ");
        answerModel38.setId(38l);
        answerModel38.setQuestionModel(questionModel10);
        answerService.saveAnswer(answerModel38);

        QuestionModel questionModel11 = new QuestionModel("What size animal?", false);
        questionModel11.setId(11l);
        questionModel11.setQuestionOrder(11.0);
        questionService.saveQuestion(questionModel11);

        AnswerModel answerModel39 = new AnswerModel("Small");
        answerModel39.setId(39l);
        answerModel39.setQuestionModel(questionModel11);
        answerService.saveAnswer(answerModel39);

        AnswerModel answerModel40 = new AnswerModel("Medium");
        answerModel40.setId(40l);
        answerModel40.setQuestionModel(questionModel11);
        answerService.saveAnswer(answerModel40);

        AnswerModel answerModel41 = new AnswerModel("Large");
        answerModel41.setId(41l);
        answerModel41.setQuestionModel(questionModel11);
        answerService.saveAnswer(answerModel41);

        QuestionModel questionModel12 = new QuestionModel("Social activity?", false);
        questionModel12.setId(12l);
        questionModel12.setQuestionOrder(12.0);
        questionService.saveQuestion(questionModel12);

        AnswerModel answerModel42 = new AnswerModel("Introvert?");
        answerModel42.setId(42l);
        answerModel42.setQuestionModel(questionModel12);
        answerService.saveAnswer(answerModel42);

        AnswerModel answerModel43 = new AnswerModel("Extrovert?");
        answerModel43.setId(43l);
        answerModel43.setQuestionModel(questionModel12);
        answerService.saveAnswer(answerModel43);

        QuestionModel questionModel13 = new QuestionModel("Sunshine or rainy day?", false);
        questionModel13.setId(13l);
        questionModel13.setQuestionOrder(13.0);
        questionService.saveQuestion(questionModel13);

        AnswerModel answerModel44 = new AnswerModel("Sunshine");
        answerModel44.setId(44l);
        answerModel44.setQuestionModel(questionModel13);
        answerService.saveAnswer(answerModel44);

        AnswerModel answerModel45 = new AnswerModel("Rainy day");
        answerModel45.setId(45l);
        answerModel45.setQuestionModel(questionModel13);
        answerService.saveAnswer(answerModel45);

        QuestionModel questionModel14 = new QuestionModel("Beach day?", false);
        questionModel14.setId(14l);
        questionModel14.setQuestionOrder(14.0);
        questionService.saveQuestion(questionModel14);

        AnswerModel answerModel46 = new AnswerModel("Swimming");
        answerModel46.setId(46l);
        answerModel46.setQuestionModel(questionModel14);
        answerService.saveAnswer(answerModel46);

        AnswerModel answerModel47 = new AnswerModel("Sunbathe ");
        answerModel47.setId(47l);
        answerModel47.setQuestionModel(questionModel14);
        answerService.saveAnswer(answerModel47);

        AnswerModel answerModel48 = new AnswerModel("Hell nawww ");
        answerModel48.setId(48l);
        answerModel48.setQuestionModel(questionModel14);
        answerService.saveAnswer(answerModel48);

        UserModel userModel1 = new UserModel("wawawiwa", "hellohellothere", "Walta", "www@gmail.com");
        userModel1.setId(1L);
        userService.saveUser(userModel1);

    }
}
