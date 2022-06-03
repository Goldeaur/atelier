package com.atelier.tennis.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Player(
        int id,
        @JsonProperty("firstname")
        String firstName,
        @JsonProperty("lastname")
        String lastName,
        @JsonProperty("shortname")
        String shortName,
        String sex,
        Country country,
        String picture,
        @JsonProperty("data")
        Data data
) {

}
