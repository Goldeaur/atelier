package com.atelier.tennis.service;

import com.atelier.tennis.model.dto.Data;
import com.atelier.tennis.model.dto.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class StatisticsServiceTest {


    private final StatisticsService statisticsService = new StatisticsService();


    @Test
    void averageImcShouldReturnRightIMCForPLayer1() {
        Data data1 = new Data(0, 0, 80000, 188, null, null, null);
        Player player1 = new Player(0, null, null, null, null, null, null, data1);
        var data = new ArrayList(Arrays.asList(player1));
        Assertions.assertEquals(22.63, statisticsService.averageImc(data));
    }

    @Test
    void averageImcShouldReturnRightIMCForPLayer2() {
        Data data1 = new Data(0, 0, 74000, 185, null, null, null);
        Player player1 = new Player(0, null, null, null, null, null, null, data1);
        var data = new ArrayList(Arrays.asList(player1));
        Assertions.assertEquals(21.62, statisticsService.averageImc(data));
    }

    @Test
    void averageImcShouldReturnRightIMCForPLayer3() {
        Data data1 = new Data(0, 0, 81000, 183, null, null, null);
        Player player1 = new Player(0, null, null, null, null, null, null, data1);
        var data = new ArrayList(Arrays.asList(player1));
        Assertions.assertEquals(24.19, statisticsService.averageImc(data));
    }

    @Test
    void averageImcShouldReturnRightIMCForPLayer4() {
        Data data1 = new Data(0, 0, 72000, 175, null, null, null);
        Player player1 = new Player(0, null, null, null, null, null, null, data1);
        var data = new ArrayList(Arrays.asList(player1));
        Assertions.assertEquals(23.51, statisticsService.averageImc(data));
    }

    @Test
    void averageImcShouldReturnRightIMCForPLayer5() {
        Data data1 = new Data(0, 0, 85000, 185, null, null, null);
        Player player1 = new Player(0, null, null, null, null, null, null, data1);
        var data = new ArrayList(Arrays.asList(player1));
        Assertions.assertEquals(24.84, statisticsService.averageImc(data));
    }


    @Test
    void averageImcShouldReturnRightAverageWhen5Players(){
        Data data1 = new Data(0, 0, 80000, 188, null, null, null);
        Data data2 = new Data(0, 0, 74000, 185, null, null, null);
        Data data3 = new Data(0, 0, 81000, 183, null, null, null);
        Data data4 = new Data(0, 0, 72000, 175, null, null, null);
        Data data5 = new Data(0, 0, 85000, 185, null, null, null);
        Player player1 = new Player(0, null, null, null, null, null, null, data1);
        Player player2 = new Player(0, null, null, null, null, null, null, data2);
        Player player3 = new Player(0, null, null, null, null, null, null, data3);
        Player player4 = new Player(0, null, null, null, null, null, null, data4);
        Player player5 = new Player(0, null, null, null, null, null, null, data5);
        ArrayList<Player> players = new ArrayList(Arrays.asList(player1, player2, player3, player4, player5));

        Assertions.assertEquals(23.36, statisticsService.averageImc(players));
    }

}