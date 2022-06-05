package com.atelier.tennis.service;

import com.atelier.tennis.model.dto.Data;
import com.atelier.tennis.model.dto.Player;
import com.atelier.tennis.model.dto.Statistics;
import org.decimal4j.util.DoubleRounder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StatisticsService {

    private final List<Player> players;

    public StatisticsService(PlayerService playerService) {
        this.players = playerService.players;
    }

    public ResponseEntity<Statistics> statistics() {
        Statistics statistics = new Statistics(
                countryWithMostVictories(this.players),
                averageBmi(this.players),
                medianHeight(this.players)
        );
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }

    protected Double averageBmi(List<Player> players) {
        var playersData = players.stream().map(Player::data).toList();
        return DoubleRounder.round(playersData.stream()
                .mapToDouble(Data::getBmi)
                .average().getAsDouble(), 2);
    }

    protected Integer medianHeight(List<Player> players) {
        var playersData = players.stream().map(Player::data).toList();
        var playerAges = playersData.stream().map(data-> data.getHeight()).sorted().toList();
        return playerAges.get(Math.round(playerAges.size() / 2));
    }

    protected String countryWithMostVictories(List<Player> players) {
        //map with countryCode as key and last of all its players as value.
        Map<String, ArrayList<Integer>> countryCombinedLasts = new HashMap<>();
        Map<String, Double> countryRatio = new HashMap<>();

        //fill countryCombinedLasts map.
        players.forEach(player -> {
            if (!countryCombinedLasts.containsKey(player.country().code())) {
                countryCombinedLasts.put(player.country().code(), new ArrayList<>(player.data().getLast()));
            } else {
                var existingValue = countryCombinedLasts.get(player.country().code());
                existingValue.addAll(player.data().getLast());
                countryCombinedLasts.put(player.country().code(), existingValue);
            }
        });

        //calculate ratio for each country and save result in the second map.
        countryCombinedLasts.forEach((countryCode, combinedLasts) -> {
            double sum = combinedLasts.stream().mapToDouble(a -> a).sum();
            countryRatio.put(countryCode, DoubleRounder.round(sum / combinedLasts.size(), 2));
        });

        //get key for highestValue.
        return Collections.max(countryRatio.entrySet(), Map.Entry.comparingByValue()).getKey();

}


}
