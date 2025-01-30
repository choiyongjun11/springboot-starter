package com.springboot.coffee.controller;

import com.springboot.coffee.dto.CoffeePatchDto;
import com.springboot.coffee.dto.CoffeePostDto;
import com.springboot.coffee.dto.CoffeeResponseDto;
import com.springboot.coffee.entity.Coffee;
import com.springboot.coffee.mapper.CoffeeMapper;
import com.springboot.coffee.service.CoffeeService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController //Spring MVC에서 Restful 웹 서비스를 처리하기 위한 컨트롤러 입니다.
@RequestMapping("/v44/coffees") // /v44/coffees url 경로로 들어오는 요청을 처리하도록 매핑합니다.

//controller 메서드에는 http 응답 메서드 기능을 구현해줘야 합니다. !
// 1) controller 와 service, mapper를 연결 시켜여하기 때문에 생성자가 필요합니다.
// 2) 응답(Response) 에 대한 get(R), post(C), patch(U), delete(D) 기능을 이 메서드에서 구현 시킵니다.
// 3) 따라서 하난의 클래스에 여러 메서드를 담아야함 -> 메서드 오버라이딩 작업이 필요합니다.
// 4) get, patch,delete 요청은 매개변수로 고유한 id 값으로 가져와야 합니다.
// 5) get, delete 에는 (전체, 특정 번호)에 대한 두가지 방법을 고려해줘야 합니다.
// 6) post, patch (만들기, 수정하기)는 매개변수로 dto를 가져와야 합니다.
// 7) return 반환 값에는 (응답 데이터와, http 상태 코드)와 함께 응답해줘야 하는 것이 중요합니다.


//주의 사항 : 클래스 명 -> 앞 단어의 첫글자 대문자, 변수명 -> 두번째 단어의 첫글자 대문자

public class CoffeeController {

    private final CoffeeService coffeeService;
    private final CoffeeMapper coffeeMapper;

    public CoffeeController(CoffeeService coffeeService, CoffeeMapper coffeeMapper) {
        this.coffeeService = coffeeService;
        this.coffeeMapper = coffeeMapper;
    }

    //post 요청
    @PostMapping
    public ResponseEntity postCoffee(@RequestBody  CoffeePostDto coffeePostDto) {
        //coffeepostdto 를 coffee엔티티로 변환
        Coffee coffee = coffeeService.createCoffee(coffeeMapper.coffeePostDtoTocoffee(coffeePostDto));

        CoffeeResponseDto responseDto = coffeeMapper.coffeeToCoffeeResponseDto(coffee);
        return new ResponseEntity<>(responseDto,HttpStatus.CREATED);

    }

    //get 요청(특정 id 조회)
    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) {
        // URL 경로의 "coffee-id" 값을 받아서 coffeeId 변수에 저장합니다.
        Coffee coffee = coffeeService.findCoffee(coffeeId); //service 로 entity 형태로 전달
        CoffeeResponseDto responseDto = coffeeMapper.coffeeToCoffeeResponseDto(coffee); //클라이언트에게 dto 형태로 전달
        return new ResponseEntity<>(responseDto, HttpStatus.OK);

    }

    //get 요청(전체 조회)
    @GetMapping
    public ResponseEntity getCoffees() {

        List<Coffee> coffees = coffeeService.findCoffees();
        List<CoffeeResponseDto> responseDtos = coffees.stream()
                .map(coffee -> coffeeMapper.coffeeToCoffeeResponseDto(coffee))
                .collect(Collectors.toList());
        return new ResponseEntity(responseDtos, HttpStatus.OK);

    }

    //patch 요청
    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id") long coffeeId, @RequestBody CoffeePatchDto coffeePatchDto) {
        coffeePatchDto.setCoffeeId(coffeeId);
        Coffee coffee = coffeeService.updateCoffee(coffeeMapper.coffeePatchDtoToCoffee(coffeePatchDto)); //service로 전달
        CoffeeResponseDto response = coffeeMapper.coffeeToCoffeeResponseDto(coffee); //dto 를 클라이언트에게 전달
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


    //delete 요청
    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") long coffeeId) {
        // URL 경로의 "coffee-id" 값을 받아서 coffeeId 변수에 저장합니다.

        coffeeService.deleteCoffee(coffeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
