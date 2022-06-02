package com.atelier.tennis.model.dto;

import java.util.List;

public record Data(
        int rank,
        int points,
        int weight,
        int height,
        String birthday,
        List<Title> titles,
        List<Integer> last       ,
        double imc
) {
    public Data (int rank, int points, int weight, int height, String birthday, List<Title> titles, List<Integer> last) {
        this(rank, points,weight, height, birthday, titles, last, ((double)weight/1000)/(Math.pow((double)height/100, 2)));
    }


}
