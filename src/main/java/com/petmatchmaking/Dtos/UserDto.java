package com.petmatchmaking.Dtos;

import com.petmatchmaking.Models.PetModel;
import com.petmatchmaking.Models.UserModel;
import java.util.*;
/**
 * Class that models the user model data transfer object
 */
public class UserDto {
    private Long id;
    private String userId;
    private String password;
    private String name;
    private String email;

    /**
     * Default Constructor
     */
    public UserDto() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param model user model
     */
    public UserDto(UserModel model) {
        this.id = model.getId();
        this.userId = model.getUserId();
        this.password = model.getPassword();
        this.name = model.getName();
        this.email = model.getEmail();
    }

    /**
     * Method to get the user id for the user data transfer object
     * 
     * @return user id for the user data transfer object
     */
    public Long getId() {
        return id;
    }

    /**
     * Method to set the user id for the user data transfer object
     * 
     * @param id user id for the user data transfer object
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Method to get the user's login id for the user data transfer object
     * 
     * @return user's login id for the user data transfer object
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Method to set the user's login id for the user data transfer object
     * 
     * @param userId user's login id for the user data transfer object
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Method to get the user's login password for the user data transfer object
     * 
     * @return user's login password for the user data transfer object
     */
    public String getPassword() {
        return password;
    }

    /**
     * Method to set the user's login password for the user data transfer object
     * 
     * @param password the user's login password for the user data transfer object
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Method to get the user's name for the user data transfer object
     * 
     * @return the user's name for the user data transfer object
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set the user's name for the user data transfer object
     * 
     * @param name the user's name for the user data transfer object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get the user's email for the user data transfer object
     * 
     * @return the user's email for for the user data transfer object
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method to set the user's email for the user data transfer object
     * 
     * @param email the user's email for the user data transfer object
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method to convert the user data transfer object to a user model
     * 
     * @return user model
     */
    public UserModel convertToModel(Collection<PetModel> pets) {
        UserModel user = new UserModel(this.userId,this.password,this.name,this.email,pets);
        return user;
    }
}
