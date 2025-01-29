package com.springboot.coffee.service;

import com.springboot.coffee.entity.Coffee;
import org.springframework.stereotype.Service;

@Service // 서비스 계층, spring의 관리 대상 빈!

//entity 정보를 실제 데이터를 db에 저장할 수 있도록 구현해야 합니다.
// CRUD

//create, find,update, delete
//여기도 메서드 오버로드 필요합니다.

public class CoffeeService {

    public Coffee createCoffee(Coffee coffee) {
        return coffee;
    }

    public Coffee findCoffee() {
        return coffee;
    }
    public Coffee findCoffees() {
        return coffee;
    }

    public Coffee updateCoffee(Coffee coffee) {
        return coffee;
    }

    public void deleteCoffee(long coffeeId) {
    //삭제 기능은 반환 타입이 없으므로 void

    }

}
