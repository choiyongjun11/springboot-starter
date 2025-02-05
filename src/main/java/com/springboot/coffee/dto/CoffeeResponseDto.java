package com.springboot.coffee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter

public class CoffeeResponseDto {
    private long coffeeId;
    private String korName;
    private String engName;
    private int price;

}
