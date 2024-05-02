package com.petmatchmaking.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.petmatchmaking.Dtos.RulebookDto;
import com.petmatchmaking.Models.RulebookModel;
import com.petmatchmaking.Services.RulebookService;
import jakarta.annotation.Resource;

@Controller
@RequestMapping("/rulebooks/")
public class RulebookController {

    @Resource
    private final RulebookService rulebookService;

    /**
     * parameterized constructor
     * 
     * @param rulebookService
     */
    public RulebookController(RulebookService rulebookService) {
        this.rulebookService = rulebookService;
    }

    /**
     * get all rulebooks
     * 
     * @return
     */
    @GetMapping
    public Iterable<RulebookModel> getAllRulebooks() {
        return rulebookService.findAll();
    }

    /**
     * return by specific id
     * 
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public RulebookDto getRulebook(@PathVariable Long id, Model model) {
        RulebookModel rulebookModel = rulebookService.findById(id);
        RulebookDto dto = new RulebookDto(rulebookModel);
        return dto;
    }

    /**
     * deletes a rulebook
     * 
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public boolean deleteRulebook(@PathVariable Long id) {
        return rulebookService.deleteRulebook(id);
    }

    /**
     * add a rulebook
     * 
     * @param rulebookDto
     * @return
     */
    @PostMapping
    public RulebookModel addRulebook(@RequestBody RulebookDto rulebookDto) {
        RulebookModel rulebookModel = rulebookDto.convertToModel();
        return rulebookService.saveRulebook(rulebookModel);
    }

    /**
     * 
     * @param rulebookDto
     * @return
     */
    @PutMapping
    public RulebookModel saveRulebook(@RequestBody RulebookDto rulebookDto) {
        RulebookModel rulebookModel = rulebookDto.convertToModel();
        return rulebookService.saveRulebook(rulebookModel);
    }
}
