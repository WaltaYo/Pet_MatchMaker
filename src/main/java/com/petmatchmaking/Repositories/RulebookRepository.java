package com.petmatchmaking.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.petmatchmaking.Models.RulebookModel;

/**
 * Interface for the CRUD and expanded CRUD operation for the Rulebook;
 */

public interface RulebookRepository extends CrudRepository<RulebookModel, Long> {
    
}
