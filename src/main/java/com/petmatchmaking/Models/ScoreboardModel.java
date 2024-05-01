package com.petmatchmaking.Models;

import java.util.*;

import jakarta.persistence.*;
@Entity
@Table(name = "t_Scoreboards")
public class ScoreboardModel {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "userModel", cascade = CascadeType.ALL)
    private UserModel user;

    private ArrayList<PetModel> pets;

    public ScoreboardModel() {
    }

    /**
     * gives us 1 user w/ array of pet types
     */
    public ScoreboardModel(UserModel user, ArrayList<PetModel> pets) {
        this.user = user;
        this.pets = pets;
    }

    public Long getId() {
        return id;
    }

    public UserModel getUser() {
        return user;
    }

    public ArrayList<PetModel> getPets() {
        return pets;
    }

    
}

