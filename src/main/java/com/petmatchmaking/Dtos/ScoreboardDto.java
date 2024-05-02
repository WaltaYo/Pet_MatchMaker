package com.petmatchmaking.Dtos;

import java.util.ArrayList;

import org.hibernate.mapping.Collection;

import com.petmatchmaking.Models.PetModel;
import com.petmatchmaking.Models.ScoreboardModel;
import com.petmatchmaking.Models.UserModel;

public class ScoreboardDto {

  
    private int currentScore;
    private String petType;

    /**
     * Parameterized Constructor
     * 
     * @param model Scoreboard Model
     */
    public ScoreboardDto(ScoreboardModel model) {
      this.currentScore = model.getScore();
      this.petType = model.getPet().getPetType();
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public String getPetType() {
        return petType;
    }   

}
