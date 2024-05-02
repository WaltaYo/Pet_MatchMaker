package com.petmatchmaking.Controllers;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.petmatchmaking.Dtos.ScoreboardDto;
import com.petmatchmaking.Models.*;
import com.petmatchmaking.Services.*;

import jakarta.annotation.Resource;

/**
 * Class that models the mapping of the score board table
 */
@Controller
@RequestMapping("scoreboard")
public class ScoreBoardController {

    @Resource
    private final ScoreBoardService scoreBoardService;

    /**
     * Parameterized Constructor
     * 
     * @param scoreBoardService score board services
     */
    public ScoreBoardController(ScoreBoardService scoreBoardService) {
        this.scoreBoardService = scoreBoardService;
    }

    /**
     * Method to map getting all score boards
     * 
     * @return score boards
     * 
     */
    @GetMapping
    public Iterable<ScoreboardModel> getAllScoreBoards(){
        return scoreBoardService.findAll();
    }

    /**
     * Method to get score board by id
     * 
     * @param id scoreboard id
     * 
     * @param model scoreboard model
     * 
     * @return
     */
    @GetMapping("id")
    public String getScoreBoard(@PathVariable Long id, Model model){
        ScoreboardModel scoreboardModel = scoreBoardService.findById(id);
        UserModel user = scoreboardModel.getUser();
        model.addAttribute("scoreboardModel", scoreboardModel);
        model.addAttribute("user", user );
        return "/";
    }

    /**
     * Method to delete a score board
     * 
     * @param id score board id
     * 
     * @return if the deletion of the score board was successful
     */
    @DeleteMapping("{id}")
    public boolean deleteScoreBoard(@PathVariable Long id){
        return scoreBoardService.deleteScoreBoard(id);
    
    }

    /**
     * Method to add score board
     * 
     * @param dto data transfer object for score board
     * 
     * @return updated score board
     */
    @PostMapping
    public ScoreboardModel addScoreBoard(@RequestBody ScoreboardDto dto) {
        ScoreboardModel scoreboardModel = dto.convertToModel();
        return scoreBoardService.saveScoreBoard(scoreboardModel);
    }

    /**
     * Method to save score board
     * 
     * @param dto data transfer object for score board
     * 
     * @return score board updated
     */
    @PutMapping
    public ScoreboardModel saveScoreBoard(@RequestBody ScoreboardDto dto) {
        ScoreboardModel scoreboardModel = dto.convertToModel();
        return scoreBoardService.saveScoreBoard(scoreboardModel);
    }

}
