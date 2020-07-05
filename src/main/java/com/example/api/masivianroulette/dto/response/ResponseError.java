package com.example.api.masivianroulette.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
public class ResponseError {
	
    private LocalDate timestamp;
    private String message;
    
}