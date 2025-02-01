package com.springboot.coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Coffee {
    private long coffeeId;
    private String korName;
    private String engName;
    private int price;
}
