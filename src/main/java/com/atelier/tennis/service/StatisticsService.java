package com.atelier.tennis.service;

import com.atelier.tennis.model.dto.Data;
import com.atelier.tennis.model.dto.Player;
import com.atelier.tennis.model.dto.Statistics;
import org.decimal4j.util.DoubleRounder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StatisticsService {

    public ResponseEntity<Statistics> statistics() {
        return null;
    }

    private String bestCountry(ArrayList<Player> players) {

        return null;
    }
//TODO Why this is not working ?
    public Double averageImc(ArrayList<Player> players) {
        var playersData = players.stream().map(Player::data).toList();
        return DoubleRounder.round(playersData.stream()
                .mapToDouble(Data::imc)
                .average().getAsDouble(), 2);
    }
}
