package com.springboot.order.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor //전체 생성자`
public class Order {
    private long memberId; //주문한 사람 id
    private long coffeeId; //주문한 커피 id
}
