package br.com.petz.clientpet.handlers;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public record ErrorApiResponse(
        String message,

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        List<String> description
) {
    public ErrorApiResponse(String message){
        this(message, List.of());
    }
}
