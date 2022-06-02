package com.atelier.tennis.model.dto;

import java.util.ArrayList;

public record Title(
        int year,
        int victories,
        ArrayList<String> tournaments
) {
}
