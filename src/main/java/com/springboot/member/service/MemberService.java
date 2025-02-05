package com.springboot.member.service;

import com.springboot.exception.BusinessLogicException;
import com.springboot.exception.ExceptionCode;
import com.springboot.member.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService { //service는 entity 로 반환을 시켜야 합니다.

    public Member createMember(Member member) {
        Member createdMember = member;
        return createdMember;
    }

    public Member findMember(long memberId) {
        Member member = new Member(memberId,"asd123@gmail.com", "김라임", "010-1234-5555");
        return member;

        //조회에 실패했을 경우 고려하여 예외처리 기능(서비스 계층에서 처리해야 한다)
        // throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND);
    }

    public List<Member> findMembers() {
        List<Member> members =  List.of(
                new Member(1L, "asd44@gmail.com", "홍길이", "010-4444-5656"),
                new Member(2L, "hho24@gmail.com", "이루미", "010-7677-9999")
        );
        return members;
    }

    public Member updateMember(Member member) {
        Member updatedMember = member;
        return updatedMember;
    }

    public void deleteMember(long memberId) {

        String logResult = null; //아무것도 없다고 표시
        System.out.println(logResult.toUpperCase()); //대문자로 표시

    }


}
