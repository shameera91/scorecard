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

/**
 * Created By Shameera.A on 3/31/2020
 */

@Entity
@Table(name = "metrics")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Metrics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String scoreCard;
    private String metric;
    private String category;
}
