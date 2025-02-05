package com.springboot.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter

public class MemberResponseDto {
    private long memberId;
    private String email;
    private String name;
    private String phone;
}
