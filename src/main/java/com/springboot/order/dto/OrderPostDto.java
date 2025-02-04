package com.springboot.order.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter
@Setter
public class OrderPostDto {
    @Positive
    private long memberId;

    @Positive
    private long coffeeId;


}
