package com.scorecard.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created By Shameera.A on 2/4/2020
 */
@Entity
@Table(name = "scorecard")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScoreCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String scorecard;
    private String scorecardCategory;
    private String metric;
    private String breakout;
    private String category;
    private String reportingFrequency;
    private String metricFormat;
    private String statusCalculation;
    private float rangeTolerance;
    private String monthYear;
    private float targetValue;
    private float forecastValue;
    private float actualValue;
    private float actualNumerator;
    private float actualDenominator;
    private String comments;
    private String linkToRca;
    private float redStatusLimit;
    private String status;
    private Date dateUploaded;

}
