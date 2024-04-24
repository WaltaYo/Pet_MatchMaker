package com.petmatchmaking.Dtos;

import com.petmatchmaking.Enums.PetTypeEnum;
import com.petmatchmaking.Models.PetModel;

/**
 * Class that models the pet model data transfer object
 */
public class PetDto {
  
    private Long id;
    private PetTypeEnum petType;
    private String petAge;

    /**
     * Default Constructor
     */
    public PetDto() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param model Pet Model
     */
    public PetDto(PetModel model) {
        this.id = model.getId();
        this.petType = model.getPetType();
        this.petAge = model.getPetAge();
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
     * Method to set the pet id
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
    public PetTypeEnum getPetType() {
        return petType;
    }

    /**
     * Method to set the pet type
     * 
     * @param petType pet type
     */
    public void setPetType(PetTypeEnum petType) {
        this.petType = petType;
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
     * Method to set the pet age
     * 
     * @param petAge pet age
     */
    public void setPetAge(String petAge) {
        this.petAge = petAge;
    }

    /**
     * Method to convert the pet data transfer object to a pet model
     * 
     * @return a pet model
     */
    public PetModel convertToModel() {
        PetModel pet = new PetModel(
                this.getPetType(),
                this.getPetAge());
        return pet;
    }
}
