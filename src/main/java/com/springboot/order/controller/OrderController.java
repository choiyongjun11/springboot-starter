package com.springboot.order.controller;


import com.springboot.order.dto.OrderPostDto;
import com.springboot.order.dto.OrderResponseDto;
import com.springboot.order.entity.Order;
import com.springboot.order.mapper.OrderMapper;
import com.springboot.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v5/orders") //서비스 계층과 api 게층 연동
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper mapper;

    public OrderController(OrderService orderService, OrderMapper mapper) {
        this.orderService = orderService;
        this.mapper = mapper;
    }

    //  ResponseEntity -> post, patch, get, del url 메서드

    @PostMapping
    public ResponseEntity postOrder(@RequestBody OrderPostDto orderPostDto) {
        Order order = orderService.createOrder(mapper.orderPostDtoToOrder(orderPostDto));
        return new ResponseEntity<>(mapper.orderToOrderResponseDto(order), HttpStatus.CREATED);
    }

    @GetMapping("/{order-id}")
    public ResponseEntity getOrder(@PathVariable("order-id") long orderId) {
        Order order = orderService.findOrder(orderId);
        return new ResponseEntity<>(mapper.orderToOrderResponseDto(order), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getOrders() {

        List<Order> orders = orderService.findOrders();

        List<OrderResponseDto> response = orders.stream()
                .map(order -> mapper.orderToOrderResponseDto(order))
                .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{order-id}")
    public ResponseEntity cancelOrder(@PathVariable("order-id") long orderId) {

        orderService.cancelOrder();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
