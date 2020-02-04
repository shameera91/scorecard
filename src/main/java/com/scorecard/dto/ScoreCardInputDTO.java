package com.scorecard.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created By Shameera.A on 2/4/2020
 */
@Getter
@Setter
public class ScoreCardInputDTO {

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
