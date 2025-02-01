package com.springboot.member.controller;

import com.springboot.member.dto.MemberPatchDto;
import com.springboot.member.dto.MemberPostDto;
import com.springboot.member.dto.MemberResponseDto;
import com.springboot.member.entity.Member;
import com.springboot.member.mapper.MemberMapper;
import com.springboot.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v5/members")

public class MemberController {

    private MemberService memberService;
    private MemberMapper mapper;

    public MemberController(MemberService memberService, MemberMapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
    }

    public ResponseEntity postMember(@RequestBody MemberPostDto memberPostDto) {

        Member member = mapper.memberPostDtoToMember(memberPostDto);

        Member response = memberService.createMember(member);

        return new ResponseEntity<>(mapper.memberToMemberResponseDto(response),HttpStatus.CREATED);

    }

    public ResponseEntity patchMember(@PathVariable("member-id") long memberId,
                                      @RequestBody MemberPatchDto memberPatchDto) {
            memberPatchDto.setMemberId(memberId);
            Member response =
                    memberService.updateMember(mapper.memberPatchDtoToMember(memberPatchDto));

            return new ResponseEntity<>(mapper.memberToMemberResponseDto(response), HttpStatus.OK);
        }

    public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId) {
            Member response = memberService.findMember(memberId);
            return new ResponseEntity<>(mapper.memberToMemberResponseDto(response),HttpStatus.OK);
    }

    public ResponseEntity getMembers(){
        List<Member> members = memberService.findMembers();
        List<MemberResponseDto> response =
                members.stream()
                        .map(member -> mapper.memberToMemberResponseDto(member))
                        .collect(Collectors.toList());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive long memberId) {
        memberService.deleteMember(memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
