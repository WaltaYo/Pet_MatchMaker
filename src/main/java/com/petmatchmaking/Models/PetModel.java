package com.petmatchmaking.Models;



import java.util.Collection;

import jakarta.persistence.*;

/**
 * Class that models the pets
 */
@Entity
@Table(name = "t_Pets")
public class PetModel {
    @Id
    @GeneratedValue()
    private Long id;

    @Column(nullable = false)
    private String petType;

    @Column(length = 3, nullable = false)
    private int score = 10;

    // @OneToMany(mappedBy = "rulebookModel", cascade = CascadeType.ALL)
    // private Collection<RulebookModel> rulebooks;


    /**
     * Default Constructor
     */
    public PetModel() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param petType pet type
     * 
     */
    public PetModel(String petType, int score) {
        this.petType = petType;
        this.score = score;
      
    }

    /**
     * Method to get the pet id
     * 
     * @return pet id
     */
    public Long getId() {
        return id;
    }

    /**
     * Method to set the pet id  //TO BE DELETED LATERRRR
     * 
     * @param id pet id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Method to get the pet type
     * 
     * @return pet type
     */
    public String getPetType() {
        return petType;
    }

    public int getScore() {
        return score;
    }
    

    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Override method for toString
     */
    @Override
    public String toString() {
        return "PetModel [id=" + id + ", petType=" + petType + ", score=" + score + "]";
    }
}
