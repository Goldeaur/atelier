package com.atelier.tennis.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@ToString
@NoArgsConstructor
public final class Data {
    private int rank;
    private int points;
    private int weight;
    private int height;
    private String birthday;
    private List<Title> titles;
    private List<Integer> last;
    private double bmi;


    public Data(int rank, int points, int weight, int height, String birthday, List<Title> titles, List<Integer> last) {
        this.rank = rank;
        this.points = points;
        this.weight = weight;
        this.height = height;
        this.birthday = birthday;
        this.titles = titles;
        this.last = last;
        this.bmi = ((double) weight / 1000) / (Math.pow((double) height / 100, 2));
    }

    public double bmi() {
        return ((double) weight / 1000) / (Math.pow((double) height / 100, 2));
    }

}
