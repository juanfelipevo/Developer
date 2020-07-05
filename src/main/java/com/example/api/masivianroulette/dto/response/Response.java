package com.example.api.masivianroulette.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
public class Response<T> {

    
    private T payload;
    private Object errors;

}
