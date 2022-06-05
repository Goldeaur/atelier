package com.atelier.tennis.service;

import com.atelier.tennis.model.dto.Player;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.decimal4j.util.DoubleRounder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@Service
public class PlayerService {

    public final List<Player> players = loadData();

    public PlayerService() throws IOException {
    }

    private List<Player> loadData() throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        Path path = Path.of("src/main/resources/data/completed.json");
        String json = Files.readString(path);

        var data = objectMapper.readValue(json, Player[].class);
        List<Player> players =  List.of(data);

        players.forEach(player -> player.data().setBmi(calculateBMI(player)));
        return players;
    }

    public double calculateBMI(Player player){
        return DoubleRounder.round(((double) player.data().getWeight() / 1000) / (Math.pow((double) player.data().getHeight() / 100, 2)), 2);
    }

    public ArrayList<Player> findAllSortedByRank() {
        ArrayList<Player> sorted = new ArrayList<>(players);
        sorted.sort(Comparator.comparingInt((Player player) -> player.data().getRank()));
        return sorted;
    }

    public ResponseEntity<Player> findPlayer(int id) {
        var result = players.stream().filter(player -> player.id() == id).toList();
        return result.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(result.get(0), HttpStatus.OK);
    }
}
