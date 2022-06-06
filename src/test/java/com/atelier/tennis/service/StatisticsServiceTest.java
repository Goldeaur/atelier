package com.atelier.tennis.service;

import com.atelier.tennis.model.dto.Country;
import com.atelier.tennis.model.dto.Data;
import com.atelier.tennis.model.dto.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

class StatisticsServiceTest {

    private final PlayerService playerService = new PlayerService();
    private final StatisticsService statisticsService = new StatisticsService(this.playerService);

    StatisticsServiceTest() throws IOException {
    }

    @Test
    void ageShouldBe1WhenBirthdayIsNowMinus13Month() {
        LocalDate nowMinus13Months = LocalDate.now().minusMonths(13L);
        String format = nowMinus13Months.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Assertions.assertEquals(1, playerService.calculateAge(format));
    }

    @Test
    void ageShouldBe1WhenBirthdayIsNowMinus23Month() {
        LocalDate nowMinus13Months = LocalDate.now().minusMonths(23L);
        String format = nowMinus13Months.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Assertions.assertEquals(1, playerService.calculateAge(format));
    }

    @Test
    void ageShouldBe1WhenBirthdayIsNowMinus24Month() {
        LocalDate nowMinus13Months = LocalDate.now().minusMonths(24L);
        String format = nowMinus13Months.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Assertions.assertEquals(2, playerService.calculateAge(format));
    }

    @Test
    void ageShouldBe1WhenBirthdayIsNowMinus25Month() {
        LocalDate nowMinus13Months = LocalDate.now().minusMonths(25L);
        String format = nowMinus13Months.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Assertions.assertEquals(2, playerService.calculateAge(format));
    }


    @Test
    void averageImcShouldReturnRightBmiForPLayer1() {
        Data data1 = new Data(0, 0, 80000, 188, null, null, null, 0, 0);
        Player player1 = new Player(0, null, null, null, null, null, null, data1);
        Assertions.assertEquals(22.63, playerService.calculateBMI(player1));
        data1.setBmi(playerService.calculateBMI(player1));
        var data = List.of(player1);
        Assertions.assertEquals(22.63, statisticsService.averageBmi(data));
    }

    @Test
    void averageBmiShouldReturnRightAverageWhen5Players(){
        Data data1 = new Data(0, 0, 80000, 188, null, null, null, 0,0);
        Data data2 = new Data(0, 0, 74000, 185, null, null, null, 0,0);
        Data data3 = new Data(0, 0, 81000, 183, null, null, null, 0,0);
        Data data4 = new Data(0, 0, 72000, 175, null, null, null,0,0);
        Data data5 = new Data(0, 0, 85000, 185, null, null, null,0,0);
        Player player1 = new Player(0, null, null, null, null, null, null, data1);
        Player player2 = new Player(0, null, null, null, null, null, null, data2);
        Player player3 = new Player(0, null, null, null, null, null, null, data3);
        Player player4 = new Player(0, null, null, null, null, null, null, data4);
        Player player5 = new Player(0, null, null, null, null, null, null, data5);
        data1.setBmi(playerService.calculateBMI(player1));
        data2.setBmi(playerService.calculateBMI(player2));
        data3.setBmi(playerService.calculateBMI(player3));
        data4.setBmi(playerService.calculateBMI(player4));
        data5.setBmi(playerService.calculateBMI(player5));
        List<Player> players = Arrays.asList(player1, player2, player3, player4, player5);

        Assertions.assertEquals(23.36, statisticsService.averageBmi(players));
    }

    @Test
    void medianAgeShouldBeCorrectWhenOnlyOnePLayer(){
        Data data1 = new Data(0, 0, 80000, 188, null, null, null, 0,0);

        Player player1 = new Player(0, null, null, null, null, null, null, data1);

        List<Player> players = List.of(player1);

        Assertions.assertEquals(188, statisticsService.medianHeight(players));
    }

    @Test
    void medianAgeShouldBeCorrectWhenThreePLayers(){
        Data data1 = new Data(0, 0, 80000, 188, null, null, null,0,0);
        Data data2 = new Data(0, 0, 74000, 185, null, null, null,0,0);
        Data data3 = new Data(0, 0, 81000, 183, null, null, null,0,0);

        Player player1 = new Player(0, null, null, null, null, null, null, data1);
        Player player2 = new Player(0, null, null, null, null, null, null, data2);
        Player player3 = new Player(0, null, null, null, null, null, null, data3);

        List<Player> players = Arrays.asList(player1, player2, player3);

        Assertions.assertEquals(185, statisticsService.medianHeight(players));
    }

    @Test
    void medianAgeShouldBeCorrectWhenFourPLayers(){
        Data data1 = new Data(0, 0, 80000, 188, null, null, null,0,0);
        Data data2 = new Data(0, 0, 74000, 200, null, null, null,0,0);
        Data data3 = new Data(0, 0, 81000, 183, null, null, null,0,0);
        Data data4 = new Data(0, 0, 72000, 175, null, null, null,0,0);
        Player player1 = new Player(0, null, null, null, null, null, null, data1);
        Player player2 = new Player(0, null, null, null, null, null, null, data2);
        Player player3 = new Player(0, null, null, null, null, null, null, data3);
        Player player4 = new Player(0, null, null, null, null, null, null, data4);

        List<Player> players = Arrays.asList(player1, player2, player3, player4);

        Assertions.assertEquals(188, statisticsService.medianHeight(players));
    }

    @Test
    void medianAgeShouldBeCorrectWhenFivePLayers(){
        Data data1 = new Data(0, 0, 80000, 188, null, null, null,0,0);
        Data data2 = new Data(0, 0, 74000, 200, null, null, null,0,0);
        Data data3 = new Data(0, 0, 81000, 183, null, null, null,0,0);
        Data data4 = new Data(0, 0, 72000, 175, null, null, null,0,0);
        Data data5 = new Data(0, 0, 85000, 185, null, null, null,0,0);
        Player player1 = new Player(0, null, null, null, null, null, null, data1);
        Player player2 = new Player(0, null, null, null, null, null, null, data2);
        Player player3 = new Player(0, null, null, null, null, null, null, data3);
        Player player4 = new Player(0, null, null, null, null, null, null, data4);
        Player player5 = new Player(0, null, null, null, null, null, null, data5);

        List<Player> players = Arrays.asList(player1, player2, player3, player4, player5);

        Assertions.assertEquals(185, statisticsService.medianHeight(players));
    }

    @Test
    void bestCountryShouldBeFRA(){
        Data data1 = new Data(0, 0, 80000, 188, null, null, Arrays.asList(1,1,1,1,1),0,0);
        Data data2 = new Data(0, 0, 74000, 200, null, null, Arrays.asList(1,1,1,1,1),0,0);
        Data data3 = new Data(0, 0, 81000, 183, null, null, Arrays.asList(1,1,1,0,0),0,0);
        Data data4 = new Data(0, 0, 72000, 175, null, null, Arrays.asList(1,0,1,0,1),0,0);
        Data data5 = new Data(0, 0, 85000, 185, null, null, Arrays.asList(0,0,0,0,1),0,0);
        Country country1 = new Country(null, "FRA");
        Country country2 = new Country(null, "FRA");
        Country country3 = new Country(null, "USA");
        Country country4 = new Country(null, "USA");
        Country country5 = new Country(null, "USA");
        Player player1 = new Player(0, null, null, null, null, country1, null, data1);
        Player player2 = new Player(0, null, null, null, null, country2, null, data2);
        Player player3 = new Player(0, null, null, null, null, country3, null, data3);
        Player player4 = new Player(0, null, null, null, null, country4, null, data4);
        Player player5 = new Player(0, null, null, null, null, country5, null, data5);

        List<Player> players = Arrays.asList(player1, player2, player3, player4, player5);

        Assertions.assertEquals("FRA", statisticsService.countryWithMostVictories(players));
    }





}