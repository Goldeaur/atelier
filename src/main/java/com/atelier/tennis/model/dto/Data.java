package com.atelier.tennis.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Data {
    private int rank;
    private int points;
    private int weight;
    private int height;
    private String birthday;
    private List<Title> titles;
    private List<Integer> last;
    private double bmi;

}