package com.petmatchmaking.Models;



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
    public PetModel(String petType) {
        this.petType = petType;
     
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
    public String getPetType() {
        return petType;
    }





    /**
     * Override method for toString
     */
       @Override
    public String toString() {
        return "PetModel [id=" + id + ", petType=" + petType + "]";
    }

    
}
