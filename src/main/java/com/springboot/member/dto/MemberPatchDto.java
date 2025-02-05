package com.springboot.member.dto;

import com.springboot.validator.NotSpace;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;


//dto 클래스 안에 있는 것을 가져다 쓰기에 setter 설정을 하지 말아야 합니다.
// 하지만 그럼에도 patch(수정) 기능을 사용 할때 id 값으로 주고 받은니 id 에 대한 것만 setter 기능을 넣어줘야 합니다.
//valid 검증을 위해 @NotSpace, @Pattern 을 추가했습니다.
//Pattern 유효한 숫자, 문자열이 들어왔는지 확인하는 기능, \\d 다음문자가 들어오는 것을 대상합니다.

@Getter
@Setter
public class MemberPatchDto {
    private long memberId;

    @NotSpace(message = "회원 이름은 공백이 아니어야 합니다")
    private String name;

    @NotSpace(message = "휴대폰 번호는 공백이 아니어야 합니다.")
    @Pattern(regexp = "^010-\\d{3,4}-\\d{4}$",
            message = "휴대폰 번호는 010으로 시작하는 11자리 숫자와 '-'로 구성되어야 합니다")
    private String phone;



}
