package com.petmatchmaking.Models;

import java.util.*;

import com.petmatchmaking.Dtos.PetDto;

import jakarta.persistence.*;
@Entity
@Table(name = "t_Scoreboards")
public class ScoreboardModel {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private UserModel user;

    @OneToOne(mappedBy = "petModel")
    private PetModel pet;

    private int score;

    public ScoreboardModel() {
    }

    /**
     * gives us 1 user w/ array of pet types
     */
    public ScoreboardModel(UserModel user, PetModel pet ) {
        this.user = user;     
        this.pet = pet;
        this.score = pet.getDefaultScore();
    }

    public Long getId() {
        return id;
    }

    public UserModel getUser() {
        return user;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public PetModel getPet() {
        return pet;
    }
    
}

