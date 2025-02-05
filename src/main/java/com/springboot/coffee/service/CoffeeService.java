package com.springboot.coffee.service;

import com.springboot.coffee.entity.Coffee;
import com.springboot.member.entity.Member;
import org.springframework.stereotype.Service;
import java.util.List;


//entity 정보를 실제 데이터를 db에 저장할 수 있도록 구현해야 합니다.
// CRUD

//create, find,update, delete
//여기도 메서드 오버로드 필요합니다.

@Service
public class CoffeeService {

    public Coffee createCoffee(Coffee coffee) {
        return coffee;
    }

    public Coffee updateCoffee(Coffee coffee) {
        // Coffee updatedCoffee = coffee;
       // return updatedCoffee;

        return coffee;
    }

    public Coffee findCoffee(long coffeeId) {
        Coffee coffee = new Coffee(coffeeId, "아메리카노", "Americao", 2500);
        return coffee;
    }

    public List<Coffee> findCoffees() {
        List<Coffee> coffees = List.of(
                new Coffee(1L,"아메리카노","Americao",2500),
                new Coffee(2L, "캐러멜 라뗴", "Caramel Latte", 5000)

        );
        return coffees;
    }


    public void deleteCoffee(long coffeeId) {
    //삭제 기능은 반환 타입이 없으므로 void

    }

}
