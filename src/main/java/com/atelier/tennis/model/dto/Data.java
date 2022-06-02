package com.atelier.tennis.model.dto;

import java.util.List;

public record Data(
        int rank,
        int points,
        int weight,
        int height,
        String birthday,
        List<Title> titles,
        List<Integer> last
) {
}
