package com.springboot.coffee.dto;

import com.springboot.validator.NotSpace;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter

public class CoffeePatchDto {
    private long coffeeId; // 커피 ID를 저장하는 필드입니다.

    @NotSpace(message = "커피명(한글)은 공백이 아니어야 합니다.")
    private String korName; // 커피 이름(한글)을 저장하는 필드입니다.

    @NotSpace
    @Pattern( // engName 필드에 유효성 검사를 적용합니다.
            regexp = "^([A-Za-z])(\\s?[A-Za-z])*$", // 영문 이름 형식을 검증하는 정규식입니다. 영어 단어로 이루어진 이름만 허용합니다.
            message = "커피명(영문)은 영문이어야 합니다. 예) Cafe Latte" // 유효성 검사가 실패할 경우 표시할 메시지입니다.
    )
    private String engName;

    @Range( // price 필드에 유효성 검사를 적용합니다.
            min = 100, // 가격의 최소값을 100으로 제한합니다.
            max = 50000 // 가격의 최대값을 50000으로 제한합니다.
    )
    private int price;


}
