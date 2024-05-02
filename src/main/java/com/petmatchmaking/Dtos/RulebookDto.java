package com.petmatchmaking.Dtos;

import com.petmatchmaking.Models.PetModel;
import com.petmatchmaking.Models.RulebookModel;

public class RulebookDto {

    private Long id;
    private Long answerId;
    private int positiveScore;
    private int negativeScore;
    private PetModel pet;

    /**
     * default constructor
     * 
     * @param model
     */

    public RulebookDto(RulebookModel model) {
    }

    /**
     * parameterized constructor
     * 
     * @param id
     * @param asnwerId
     * @param positiveScore
     * @param negativeScore
     */
    public RulebookDto(Long id, Long asnwerId, int positiveScore, int negativeScore) {
        this.id = id;
        this.answerId = asnwerId;
        this.positiveScore = positiveScore;
        this.negativeScore = negativeScore;
        this.pet = pet;
    }

    /**
     * get the get the DTO id
     * 
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * set the DTO id
     * 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get the answer id
     * 
     * @return
     */
    public Long getAnswerId() {
        return answerId;
    }

    /**
     * set the answer id
     * 
     * @param answerId
     */
    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    /**
     * get positive score
     * 
     * @return
     */
    public int getPositiveScore() {
        return positiveScore;
    }

    /**
     * set positive score
     * 
     * @param positiveScore
     */
    public void setPositiveScore(int positiveScore) {
        this.positiveScore = positiveScore;
    }

    /**
     * get negative score
     * 
     * @return
     */
    public int getNegativeScore() {
        return negativeScore;
    }

    /**
     * set negative score
     * 
     * @param negativeScore
     */
    public void setNegativeScore(int negativeScore) {
        this.negativeScore = negativeScore;
    }

    /**
     * get the pet
     * 
     * @return pet
     */
    public PetModel getPet() {
        return pet;
    }

    /**
     * set the pet
     * 
     * @param pet
     */
    public void setPet(PetModel pet) {
        this.pet = pet;
    }

    /**
     * convert RulebookModel to DTO
     */
    public RulebookModel convertToModel() {
        RulebookModel rulebook = new RulebookModel(
                this.getAnswerId(), this.getPositiveScore(), this.getNegativeScore(), this.getPet());
        return rulebook;
    }

}
