package com.petmatchmaking.Repositories;

import java.util.Collection;


import org.springframework.data.repository.CrudRepository;


import com.petmatchmaking.Models.ScoreboardModel;

public interface ScoreBoardRepository extends CrudRepository <ScoreboardModel, Long>{
        Collection<ScoreboardModel> findByUserId(Long id);  
         //@Query("SELECT * FROM t_Scoreboards u WHERE u.user_Id = :user_Id")
        //Collection<ScoreboardModel> findforNewScoreboard(@Param("user_Id") Long userId); 
}
