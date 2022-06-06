package com.atelier.tennis.controller;

import com.atelier.tennis.model.dto.Player;
import com.atelier.tennis.model.dto.Statistics;
import com.atelier.tennis.service.PlayerService;
import com.atelier.tennis.service.StatisticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
@CrossOrigin(origins = {"*"}, maxAge = 3600)
public class PlayerController {

    private final PlayerService playerService;



    public PlayerController(PlayerService playerService, StatisticsService statisticsService) {
        this.playerService = playerService;
    }

    @GetMapping
    @CrossOrigin(origins = {"*"})
    public List<Player> getPlayers() {
        return this.playerService.findAllSortedByRank();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable int id) {
        return this.playerService.findPlayer(id);
    }

}
