package com.scorecard.service.Impl;

import com.scorecard.dto.ScoreCardInputDTO;
import com.scorecard.modal.ScoreCard;
import com.scorecard.repository.ScoreCardRepository;
import com.scorecard.service.ScoreCardService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By Shameera.A on 2/4/2020
 */
@Service
public class ScoreCardServiceImpl implements ScoreCardService {

    private final ScoreCardRepository scoreCardRepository;

    public ScoreCardServiceImpl(ScoreCardRepository scoreCardRepository) {
        this.scoreCardRepository = scoreCardRepository;
    }

    @Override
    public ScoreCard saveScoreCard(ScoreCardInputDTO input) {
        ScoreCard saveTo = ScoreCard.builder().scorecard(input.getScorecard()).scorecardCategory(input.getScorecardCategory())
                .metric(input.getMetric()).breakout(input.getBreakout()).category(input.getCategory())
                .reportingFrequency(input.getReportingFrequency()).metricFormat(input.getMetricFormat())
                .statusCalculation(input.getStatusCalculation()).rangeTolerance(input.getRangeTolerance())
                .monthYear(input.getMonthYear()).targetValue(input.getTargetValue()).forecastValue(input.getForecastValue())
                .actualValue(input.getActualValue()).actualNumerator(input.getActualNumerator())
                .actualDenominator(input.getActualDenominator()).comments(input.getComments())
                .linkToRca(input.getLinkToRca()).redStatusLimit(input.getRedStatusLimit()).status(input.getStatus())
                .dateUploaded(input.getDateUploaded()).build();
        return scoreCardRepository.save(saveTo);
    }

    @Override
    public void updateScoreCard(ScoreCardInputDTO input, long id) {
        ScoreCard scoreCard = scoreCardRepository.findById(id).get();

        scoreCard.setScorecard(input.getScorecard());
        scoreCard.setScorecardCategory(input.getScorecardCategory());
        scoreCard.setMetric(input.getMetric());
        scoreCard.setBreakout(input.getBreakout());
        scoreCard.setCategory(input.getCategory());
        scoreCard.setReportingFrequency(input.getReportingFrequency());
        scoreCard.setMetricFormat(input.getMetricFormat());
        scoreCard.setStatusCalculation(input.getStatusCalculation());
        scoreCard.setRangeTolerance(input.getRangeTolerance());
        scoreCard.setMonthYear(input.getMonthYear());
        scoreCard.setTargetValue(input.getTargetValue());
        scoreCard.setForecastValue(input.getForecastValue());
        scoreCard.setActualValue(input.getActualValue());
        scoreCard.setActualNumerator(input.getActualNumerator());
        scoreCard.setActualDenominator(input.getActualDenominator());
        scoreCard.setComments(input.getComments());
        scoreCard.setLinkToRca(input.getLinkToRca());
        scoreCard.setRedStatusLimit(input.getRedStatusLimit());
        scoreCard.setStatus(input.getStatus());
        scoreCard.setDateUploaded(input.getDateUploaded());
        scoreCardRepository.save(scoreCard);
    }

    @Override
    public ScoreCard getScoreCardById(long id) {
        ScoreCard result = scoreCardRepository.findById(id).get();
        return result;
    }

    @Override
    public List<ScoreCard> getAllScoreCards() {
        List<ScoreCard> allData = scoreCardRepository.findAll();
        return allData;
    }

    @Override
    public void deleteScoreCardById(long id) {
        scoreCardRepository.deleteById(id);
    }
}
