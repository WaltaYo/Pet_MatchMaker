package com.petmatchmaking.Models;

import com.petmatchmaking.Enums.PetTypeEnum;

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
    private PetTypeEnum petType;

    @Column(length = 3, nullable = false)
    private String petAge;

    /**
     * Default Constructor
     */
    public PetModel() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param petType pet type
     * @param petAge current pet age
     * 
     */
    public PetModel(PetTypeEnum petType, String petAge) {
        this.petType = petType;
        this.petAge = petAge;
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
     * Method to get the pet type
     * 
     * @return pet type
     */
    public PetTypeEnum getPetType() {
        return petType;
    }

    /**
     * Method to get the pet age
     * 
     * @return pet age
     */
    public String getPetAge() {
        return petAge;
    }

    /**
     * Override method for toString
     */
    @Override
    public String toString() {
        return "PetModel [id=" + id + ", petType=" + petType + ", petAge=" + petAge + "]";
    }

    
}
