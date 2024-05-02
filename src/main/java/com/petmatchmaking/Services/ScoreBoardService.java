package com.petmatchmaking.Services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.petmatchmaking.Models.ScoreboardModel;
import com.petmatchmaking.Repositories.ScoreBoardRepository;

import jakarta.annotation.Resource;

/**
 * Class that models the verification of the repository operations
 */
@Service
public class ScoreBoardService {

    @Resource
    private ScoreBoardRepository scoreBoardRepository;

    /**
     * Default Constructor
     */
    public ScoreBoardService() {
    }

    /**
     * Parameterized Constructor
     * 
     * @param scoreBoardRepository
     */
    public ScoreBoardService(ScoreBoardRepository scoreBoardRepository) {
        this.scoreBoardRepository = scoreBoardRepository;
    }

    /**
     * Method to find all score boards
     * 
     * @return score board
     */
    public Iterable<ScoreboardModel> findAll() {
        Iterable<ScoreboardModel> scoreBoard = new ArrayList<>();
        try {
            scoreBoard = scoreBoardRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return scoreBoard;
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


}
