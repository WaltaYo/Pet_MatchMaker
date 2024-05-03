package com.petmatchmaking.Services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.petmatchmaking.Dtos.ScoreboardDto;
import com.petmatchmaking.Models.ScoreboardModel;
import com.petmatchmaking.Repositories.ScoreboardRepository;
import jakarta.annotation.Resource;

/**
 * Class that models the verification of the repository operations
 */
@Service
public class ScoreboardService {

    @Resource
    private ScoreboardRepository scoreBoardRepository;

    /**
     * Default Constructor
     */
    public ScoreboardService() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param scoreBoardRepository
     */
    public ScoreboardService(ScoreboardRepository scoreBoardRepository) {
        this.scoreBoardRepository = scoreBoardRepository;
    }

    /**
     * Method to find all score boards
     * 
     * @return score board
     */
    public Iterable<ScoreboardDto> findAllByUserId(Long userId) {
        Collection<ScoreboardModel> scoreBoard = new ArrayList<>();
      
        try {
            scoreBoard = scoreBoardRepository.findByUserId(userId);
            if(scoreBoard==null){
               CreateScoreBoard(userId);
               scoreBoard = scoreBoardRepository.findByUserId(userId);
            }
           ArrayList<ScoreboardModel> list = iterableToList(scoreBoard);
            Collections.sort(list, new ScoreboardCompare());
        } catch (Exception ex) {
            throw ex;
        }
        ArrayList<ScoreboardDto> results = new ArrayList<ScoreboardDto>();

        for(ScoreboardModel model : scoreBoard){
            results.add(new ScoreboardDto(model));
        }
        return results;
    }

    private void CreateScoreBoard(Long userId){
      //  Iterable<ScoreboardModel> scoreboards = scoreBoardRepository.findforNewScoreboard(userId);
        // for(ScoreboardModel model : scoreboards){
        //     saveScoreBoard(model);
        // }
    }
    /**
     * Method to find score board by id
     * 
     * @param id
     * 
     * @return
     */
    public ScoreboardModel findById(Long id) {
        ScoreboardModel scoreBoard = null;
        try {
            Optional<ScoreboardModel> optScore = scoreBoardRepository.findById(id);
            if (optScore.isPresent()) {
                scoreBoard = optScore.get();
            }
        } catch (Exception ex) {
            throw ex;
        }
        return scoreBoard;
    }

    /**
     * Method to delete score board by ID
     * 
     * @param id score board ID
     * 
     * @return if question was deleted
     */
    public boolean deleteScoreBoard(Long id) {
        boolean result = false;
        try {
            scoreBoardRepository.deleteById(id);
            Optional<ScoreboardModel> optScore = scoreBoardRepository.findById(id);
            if (!optScore.isPresent()) {
                result = true;
            }
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    /**
     * Method to add/update score board
     * 
     * @param scoreBoard the score board to add/update
     * 
     * @return the added or updated score board 
     */
    public ScoreboardModel saveScoreBoard(ScoreboardModel scoreBoard){
        try {
          scoreBoard = scoreBoardRepository.save(scoreBoard);
        } catch (Exception ex) {
            throw ex;
        }
        return scoreBoard;
    }

 public ArrayList<ScoreboardModel> iterableToList(Iterable<ScoreboardModel> iterable) {
        ArrayList<ScoreboardModel> list = new ArrayList<>();
        for (ScoreboardModel element : iterable) {
            list.add(element);
        }
        return list;
    }
}
