package com.petmatchmaking.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.petmatchmaking.Dtos.PetDto;
import com.petmatchmaking.Models.PetModel;
import com.petmatchmaking.Services.PetService;

import jakarta.annotation.Resource;

/**
 * Class that models the mapping of the pet table
 */
@Controller
@RequestMapping("/api/v1/pets/")
public class PetController {

    @Resource
    private final PetService petService;

    /**
     * Parameterized Constructor
     * 
     * @param petService adopter services
     */
    public PetController(PetService petService) {
        this.petService = petService;
    }

    /**
     * Method to map getting all pets
     * 
     * @return all pets
     */
    @GetMapping
    public Iterable<PetModel> getAllPets() {
        return petService.findAll();
    }

    /**
     * Method to get a pet by id
     * 
     * @param id pet id
     * 
     * @return pet
     */
    @GetMapping("{id}")
    public PetDto getPet(@PathVariable Long id) {
        PetModel model = petService.findById(id);
        PetDto dto = new PetDto(model);
        return dto;
    }

    /**
     * Method to delete a pet
     * 
     * @param id pet id
     * 
     * @return if the deletion of the pet was successful
     */
    @DeleteMapping("{id}")
    public boolean deletePet(@PathVariable Long id) {
        return petService.deletePet(id);
    }

    /**
     * Method to add a pet
     * 
     * @param petModel pet to add
     * 
     * @return pet added
     */
    @PostMapping
    public PetModel addPet(@RequestBody PetDto petDto) {
        PetModel petModel = petDto.convertToModel();
        return petService.savePet(petModel);
    }

    /**
     * Method to update a pet
     * 
     * @param petModel pet to update
     * 
     * @return pet updated
     */
    @PutMapping
    public PetModel savePet(@RequestBody PetDto petDto) {
        PetModel petModel = petDto.convertToModel();
        return petService.savePet(petModel);
    }
    
}
