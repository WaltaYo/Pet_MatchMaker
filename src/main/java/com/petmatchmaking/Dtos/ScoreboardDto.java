package com.petmatchmaking.Dtos;

import java.util.ArrayList;

import org.hibernate.mapping.Collection;

import com.petmatchmaking.Models.PetModel;
import com.petmatchmaking.Models.ScoreboardModel;
import com.petmatchmaking.Models.UserModel;

public class ScoreboardDto {

    private Long id;
    private UserModel user;
    private ArrayList<PetDto> pets;
    private Iterable<UserDto> userDto;

    /**
     * Default Constructor
     */
    public ScoreboardDto() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param model Scoreboard Model
     */
    public ScoreboardDto(ScoreboardModel model) {
        this.id = model.getId();
        this.user = model.getUser();
        this.pets = convertTo(model.getPets());
        this.userDto = convertToDto(model.getUser());
    }

    /**
     * Method to convert dto to model
     * 
     * @return scoreboard
     */
    public ScoreboardModel convertToModel() {
        ScoreboardModel scoreBoard = new ScoreboardModel(
                this.getUser(), this.getPets());
        return scoreBoard;
    }

    /**
     * Method to get scoreboard id
     * 
     * @return scoreboard id
     */
    public Long getId() {
        return id;
    }

    /**
     * Method to set scoreboard id
     * 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Method to get user
     * 
     * @return user
     */
    public UserModel getUser() {
        return user;
    }

    /**
     * Method to set user
     * 
     * @param user
     */
    public void setUser(UserModel user) {
        this.user = user;
    }

    /**
     * Method to get array list of pets
     * 
     * @return
     */
    public ArrayList<PetModel> getPets() {
        return pets;
    }

    /**
     * Method to set array list of pets
     * 
     * @param pets
     */
    public void setPets(ArrayList<PetModel> pets) {
        this.pets = pets;
    }

    /**
     * Method to get the user dto
     * 
     * @return user dto
     */
    public Iterable<UserDto> getUserDto() {
        return userDto;
    }

    public void setUserDto(Iterable<UserDto> userDto) {
        this.userDto = userDto;
    }

    /**
     * Method to convert userModel to user Dto
     * 
     * @param userModel
     * @return
     */
    private ArrayList<UserDto> convertToDto(UserModel userModel) {
        ArrayList<UserDto> userDtos = new ArrayList<UserDto>();
        userDtos.add(new UserDto(userModel));
        return userDtos;
    }

}
