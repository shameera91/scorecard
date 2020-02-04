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
}
