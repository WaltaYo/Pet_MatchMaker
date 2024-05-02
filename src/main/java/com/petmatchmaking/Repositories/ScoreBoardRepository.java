package com.petmatchmaking.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.petmatchmaking.Models.ScoreboardModel;

public interface ScoreBoardRepository extends CrudRepository <ScoreboardModel, Long>{
    
}
