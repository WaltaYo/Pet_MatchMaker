package com.petmatchmaking.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "t_Rulebooks")
public class RulebookModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long answerId;

    @Column
    private boolean selected = false;

    @Column
    private int postiveScore = 0;

    @Column
    private int negativeScore = 0;

    @ManyToOne
    private PetModel pet;

    public RulebookModel() {
    }

    public RulebookModel(Long answerId, int postiveScore, int negativeScore, PetModel pet) {
        this.answerId = answerId;
        this.postiveScore = postiveScore;
        this.negativeScore = negativeScore;
        this.pet = pet;
    }

    public Long getId() {
        return id;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public boolean isSelected() {
        return selected;
    }

    public int getPostiveScore() {
        return postiveScore;
    }

    public int getNegativeScore() {
        return negativeScore;
    }

    public PetModel getPet() {
        return pet;
    }
    
}

