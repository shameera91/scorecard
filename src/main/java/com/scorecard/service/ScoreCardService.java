package com.scorecard.service;

import com.scorecard.dto.ScoreCardInputDTO;
import com.scorecard.modal.ScoreCard;

import java.util.List;

/**
 * Created By Shameera.A on 2/4/2020
 */
public interface ScoreCardService {

    ScoreCard saveScoreCard(ScoreCardInputDTO scoreCardInputDTO);

    void updateScoreCard(ScoreCardInputDTO scoreCardInputDTO,long id);

    ScoreCard getScoreCardById(long id);

    List<ScoreCard> getAllScoreCards();

    void deleteScoreCardById(long id);

    List<ScoreCard> getByCustomFilter(String scorecard, String scorecardCategory, String metric, String breakout, String category,
                           String reportingFrequency, String metricFormat, String statusCalculation, Float rangeTolerance,
                           String monthYear, Float targetValue, Float forecastValue, Float actualValue, Float actualNumerator,
                           Float actualDenominator, String comments, String linkToRca, Float redStatusLimit, String status);

}
