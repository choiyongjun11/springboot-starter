package com.springboot.coffee.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class CoffeePostDto {

    @NotBlank // korName 필드가 null, 빈 문자열, 공백 문자열이 아닌지 검증합니다.
    private String korName; // 커피 이름(한글)을 저장하는 필드입니다.

    @Pattern( // engName 필드가 지정된 정규식 패턴을 따르는지 검증합니다.
            regexp = "^([A-Za-z])(\\s?[A-Za-z])*$", // 영어 단어와 단어 사이의 공백 한 칸을 허용하는 패턴입니다.
            message = "커피명(영문)은 영문이어야 합니다(단어 사이 공백 한 칸 포함). 예) Cafe Latte"
            // 검증 실패 시 표시할 오류 메시지입니다.
    )
    private String engName; // 커피 이름(영문)을 저장하는 필드입니다.

    @Range( // price 필드의 값이 특정 범위 안에 있는지 검증합니다.
            min = 100, // 가격의 최소값을 100으로 설정합니다.
            max = 50000 // 가격의 최대값을 50000으로 설정합니다.
    )
    private int price; // 커피의 가격을 저장하는 필드입니다.


}
