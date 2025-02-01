package com.springboot.coffee.mapper;

import com.springboot.coffee.dto.CoffeePatchDto;
import com.springboot.coffee.dto.CoffeePostDto;
import com.springboot.coffee.dto.CoffeeResponseDto;
import com.springboot.coffee.entity.Coffee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring") // mapStruct의 mapper 지정하여 spring을 componentmodel 로 설정
//스프링 빈으로 등록 되도록 합니다.
public interface CoffeeMapper { //dto 와 entity 간의 변환을 담당하는 mapper 인터페이스
    //dto를 가지고 entity로 변환 시켜야 줘야합니다.
    //클라이언트 -> patch, post (dto) -> 서버로 요청 시 patch, post(entity) 변환이 필요합니다.
    // 서버 응답 -> entity를 가지고 클라이언트에게 dto로 보내줘야 하므로 변환이 필요합니다.

    Coffee coffeePatchDtoToCoffee(CoffeePatchDto coffeePatchDto);

    Coffee coffeePostDtoTocoffee(CoffeePostDto coffeePostDto);

    CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee);

    List<CoffeeResponseDto> coffeesToCoffeeResponseDtos(List<Coffee> coffees);

}
