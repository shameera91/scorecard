package com.scorecard.controller;

import com.scorecard.dto.ScoreCardInputDTO;
import com.scorecard.service.ScoreCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By Shameera.A on 2/4/2020
 */
@RestController
@RequestMapping("api/v1/scorecard")
public class ScoreCardController {

    private final ScoreCardService scoreCardService;

    public ScoreCardController(ScoreCardService scoreCardService) {
        this.scoreCardService = scoreCardService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveScoreCardData(@RequestBody ScoreCardInputDTO scoreCardInputDTO){
        return ResponseEntity.ok(scoreCardService.saveScoreCard(scoreCardInputDTO));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateScorecard(@RequestBody ScoreCardInputDTO scoreCardInputDTO, @PathVariable long id){
        scoreCardService.updateScoreCard(scoreCardInputDTO,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllScoreCards(){
        return ResponseEntity.ok(scoreCardService.getAllScoreCards());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteScorecardById(@PathVariable long id){
        scoreCardService.deleteScoreCardById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get-one/{id}")
    public ResponseEntity<?> getAllScoreCards(@PathVariable long id){
        return ResponseEntity.ok(scoreCardService.getScoreCardById(id));
    }

}
