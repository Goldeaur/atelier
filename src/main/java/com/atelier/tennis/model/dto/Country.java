package com.atelier.tennis.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Country(
        String picture,
        String code,
        String name
) {
}
