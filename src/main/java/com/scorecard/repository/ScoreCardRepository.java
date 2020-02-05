package com.scorecard.repository;

import com.scorecard.modal.ScoreCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created By Shameera.A on 2/4/2020
 */
public interface ScoreCardRepository extends JpaRepository<ScoreCard,Long> {

    @Query("SELECT s FROM ScoreCard s WHERE (s.scorecard = ?1 or ?1 is null) AND (s.scorecardCategory = ?2 or ?2 is null)" +
            "AND (s.metric = ?3 or ?3 is null) AND (s.breakout = ?4 or ?4 is null) AND (s.category = ?5 or ?5 is null)" +
            "AND (s.reportingFrequency = ?6 or ?6 is null) AND (s.metricFormat = ?7 or ?7 is null) AND (s.statusCalculation = ?8 or ?8 is null)" +
            "AND (s.rangeTolerance = ?9 or ?9 is null) AND (s.monthYear = ?10 or ?10 is null) AND (s.targetValue = ?11 or ?11 is null) " +
            "AND (s.forecastValue = ?12 or ?12 is null) AND (s.actualValue = ?13 or ?13 is null) AND (s.actualNumerator = ?14 or ?14 is null)" +
            "AND (s.actualDenominator = ?15 or ?15 is null) AND (s.comments = ?16 or ?16 is null) AND (s.linkToRca = ?17 or ?17 is null)" +
            "AND (s.redStatusLimit = ?18 or ?18 is null) AND (s.status = ?19 or ?19 is null)")
    List<ScoreCard> getByCustomFilter(String scorecard, String scorecardCategory, String metric, String breakout, String category,
                                      String reportingFrequency, String metricFormat, String statusCalculation, Float rangeTolerance,
                                      String monthYear, Float targetValue, Float forecastValue, Float actualValue, Float actualNumerator,
                                      Float actualDenominator, String comments, String linkToRca, Float redStatusLimit, String status);
}
