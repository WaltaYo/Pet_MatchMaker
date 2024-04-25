package com.petmatchmaking.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

/**
 * Class that models the user
 */
public class UserModel {
    @Id
    @GeneratedValue()
    private Long id;

    @Column(length = 20, nullable = false)
    @Size(max = 20, min = 6)
    private String userId;

    @Column(length = 25, nullable = false)
    @Size(max = 25, min = 6)
    private String password;

    @Column(length = 16, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String email;

    /**
     * Default Constructor
     */
    public UserModel() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param userId the user's login id
     * @param password the user's login password
     * @param name the user's name
     * @param email the user's email
     */
    public UserModel(String userId, String password, String name,
            String email) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    /**
     * Method to get the user id
     * 
     * @return user id
     */
    public Long getId() {
        return id;
    }
    /**
     * Method to get the user's login id
     * 
     * @return user's login id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Method to get the user's login password
     * 
     * @return user's login password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Method to get the user's name
     * 
     * @return user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get the user's email address
     * 
     * @return user's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Override method for the toString
     */
    @Override
    public String toString() {
        return "UserModel [id=" + id + ", userId=" + userId + ", password=" + password + ", name=" + name + ", email="
                + email + "]";
    }




}
