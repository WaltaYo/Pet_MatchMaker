package com.petmatchmaking.Controllers;

import org.springframework.web.bind.annotation.*;

import com.petmatchmaking.Dtos.UserDto;
import com.petmatchmaking.Models.UserModel;
import com.petmatchmaking.Services.UserService;

import jakarta.annotation.Resource;

/**
 * Class that models the mapping of the user table
 */
@RestController
@RequestMapping("/api/v1/users/")
public class UserController {

    @Resource
    private final UserService userService;

    /**
     * Parameterized Constructor
     * 
     * @param userService adopter services
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Method to map getting all users
     * 
     * @return all users
     */
    @GetMapping
    public Iterable<UserModel> getAllUsers() {
        return userService.findAll();
    }

    /**
     * Method to get a user by id
     * 
     * @param id user id
     * 
     * @return user
     */
    @GetMapping("{id}")
    public UserDto getUser(@PathVariable Long id) {
        UserModel model = userService.findById(id);
        UserDto dto = new UserDto(model);
        return dto;
    }

    /**
     * Method to delete a user
     * 
     * @param id user id
     * 
     * @return if the deletion of the user was successful
     */
    @DeleteMapping("{id}")
    public boolean deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    /**
     * Method to add a user
     * 
     * @param userModel user to add
     * 
     * @return user added
     */
    @PostMapping
    public UserModel addUser(@RequestBody UserDto userDto) {
        UserModel userModel = userDto.convertToModel();
        return userService.saveUser(userModel);
    }

    /**
     * Method to update a user
     * 
     * @param userModel user to update
     * 
     * @return user updated
     */
    @PutMapping
    public UserModel saveUser(@RequestBody UserDto userDto) {
        UserModel userModel = userDto.convertToModel();
        return userService.saveUser(userModel);
    }
    
}