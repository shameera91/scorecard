package com.scorecard.service.Impl;

import com.scorecard.dto.ScoreCardInputDTO;
import com.scorecard.modal.ScoreCard;
import com.scorecard.modal.TestTable;
import com.scorecard.repository.ScoreCardRepository;
import com.scorecard.repository.TestTableRepository;
import com.scorecard.service.ScoreCardService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created By Shameera.A on 2/4/2020
 */
@Service
public class ScoreCardServiceImpl implements ScoreCardService {

    private final ScoreCardRepository scoreCardRepository;
    private final TestTableRepository testTableRepository;

    public ScoreCardServiceImpl(ScoreCardRepository scoreCardRepository, TestTableRepository testTableRepository) {
        this.scoreCardRepository = scoreCardRepository;
        this.testTableRepository = testTableRepository;
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
    public List<ScoreCard> saveScoreCardListData(List<ScoreCardInputDTO> scoreCardInputDTO) {
        List<ScoreCard> resultList = new ArrayList<>();
        scoreCardInputDTO.stream().forEach(s -> {
            ScoreCard input = ScoreCard.builder().scorecard(s.getScorecard()).scorecardCategory(s.getScorecardCategory())
                    .metric(s.getMetric()).breakout(s.getBreakout()).category(s.getCategory())
                    .reportingFrequency(s.getReportingFrequency()).metricFormat(s.getMetricFormat())
                    .statusCalculation(s.getStatusCalculation()).rangeTolerance(s.getRangeTolerance())
                    .monthYear(s.getMonthYear()).targetValue(s.getTargetValue()).forecastValue(s.getForecastValue())
                    .actualValue(s.getActualValue()).actualNumerator(s.getActualNumerator())
                    .actualDenominator(s.getActualDenominator()).comments(s.getComments())
                    .linkToRca(s.getLinkToRca()).redStatusLimit(s.getRedStatusLimit()).status(s.getStatus())
                    .dateUploaded(s.getDateUploaded()).build();
            resultList.add(input);
        });

        return scoreCardRepository.saveAll(resultList);
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
        return scoreCardRepository.findById(id).get();
    }

    @Override
    public List<ScoreCard> getAllScoreCards() {
        return scoreCardRepository.findAll();
    }

    @Override
    public List<ScoreCard> getAllScoreCardsByYearmonth(Integer range) {
        int currentYear = LocalDate.now().getYear();
        List<String> monthYearList = new ArrayList<>();
        for(int i=0;i<range;i++){
            String currentMonth = LocalDate.now().minusMonths(i).getMonth().toString().substring(0,3);
            currentMonth = currentMonth.toUpperCase().charAt(0) +  currentMonth.toLowerCase().substring(1);
            if(currentMonth.equals("Dec") && (i != 0)){
                currentYear = LocalDate.now().minusYears(1).getYear();
            }
            monthYearList.add(currentMonth+"-"+currentYear);
        }
        return scoreCardRepository.getByMonthYearIn(monthYearList);
    }

    @Override
    @Transactional
    public void deleteScoreCardByIds(List<Long> id) {
        scoreCardRepository.deleteByIdIn(id);
    }


    @Override
    public List<ScoreCard> getByCustomFilter(String scorecard, String scorecardCategory, String metric, String breakout,
                                             String category, String reportingFrequency, String metricFormat, String statusCalculation,
                                             Float rangeTolerance, String monthYear, Float targetValue, Float forecastValue, Float actualValue,
                                             Float actualNumerator, Float actualDenominator, String comments, String linkToRca, Float redStatusLimit,
                                             String status) {

        return scoreCardRepository.getByCustomFilter(scorecard, scorecardCategory, metric, breakout, category, reportingFrequency,
                metricFormat, statusCalculation, rangeTolerance, monthYear, targetValue, forecastValue, actualValue, actualNumerator, actualDenominator,
                comments, linkToRca, redStatusLimit, status);
    }

	@Override
    public List<TestTable> getAllData() {
        return testTableRepository.findAll();
	}

	@Override
    public void updateAllScoreCards(List<ScoreCardInputDTO> scoreCardInputDTOs) {
		for (ScoreCardInputDTO inputDTO:scoreCardInputDTOs){
            updateScoreCard(inputDTO,inputDTO.getId());
        }
	}

}
