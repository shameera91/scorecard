package com.scorecard.controller;

import com.scorecard.dto.ScoreCardInputDTO;
import com.scorecard.service.ScoreCardService;
import jdk.jfr.Frequency;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/get-all")
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

    @GetMapping("/get-by")
    public ResponseEntity<?> getScorecardByCustomFilter(@RequestParam(required = false, value = "scorecard") String scorecard,
                                                        @RequestParam(required = false, value = "scorecardCategory") String scorecardCategory,
                                                        @RequestParam(required = false, value = "metric")String metric,
                                                        @RequestParam(required = false, value = "breakout") String breakout,
                                                        @RequestParam(required = false, value = "category") String category,
                                                        @RequestParam(required = false, value = "reportingFrequency") String reportingFrequency,
                                                        @RequestParam(required = false, value = "metricFormat") String metricFormat,
                                                        @RequestParam(required = false, value = "statusCalculation") String statusCalculation,
                                                        @RequestParam(required = false, value = "rangeTolerance") Float rangeTolerance,
                                                        @RequestParam(required = false, value = "monthYear") String monthYear,
                                                        @RequestParam(required = false, value = "targetValue") Float targetValue,
                                                        @RequestParam(required = false, value = "forecastValue") Float forecastValue,
                                                        @RequestParam(required = false, value = "actualValue") Float actualValue,
                                                        @RequestParam(required = false, value = "actualNumerator") Float actualNumerator,
                                                        @RequestParam(required = false, value = "actualDenominator") Float actualDenominator,
                                                        @RequestParam(required = false, value = "comments") String comments,
                                                        @RequestParam(required = false, value = "linkToRca") String linkToRca,
                                                        @RequestParam(required = false, value = "redStatusLimit") Float redStatusLimit,
                                                        @RequestParam(required = false, value = "status") String status){


        return ResponseEntity.ok(scoreCardService.getByCustomFilter(scorecard,scorecardCategory,metric,breakout,category,reportingFrequency,
                metricFormat,statusCalculation,rangeTolerance,monthYear,targetValue,forecastValue,actualValue,actualNumerator,actualDenominator,
                comments,linkToRca,redStatusLimit,status));
    }

}
