package com.springboot.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // 객체의 필드를 읽기 전용으로 유지하고 싶을 때 사용하는 것입니다.
@Setter //주의 사항 불변 객체를 만들고 싶을 때는 사용하지 않는다.
@NoArgsConstructor //매개 변수가 없는 기본 생성자를 자동 생성한다.
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자를 자동 생성한다.
//@Builder -> 객체를 불변하게 유지하고 싶을 때 사용합니다.

public class Member {

    private long memberId;

    private String email;

    private String name;

    private String phone;


}
