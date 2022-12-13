package com.dokim.younghan_spring_basic.service;

import com.dokim.younghan_spring_basic.domain.Member;
import com.dokim.younghan_spring_basic.repository.MemberMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    //MemberService memberService = new MemberService();
    //MemberMemberRepository memberRepository = new MemberMemberRepository();


//
    MemberService memberService;
    MemberMemberRepository memberRepository;
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemberMemberRepository();
        memberService = new MemberService(memberRepository);
    }
//


    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }


    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("dokim");

        //when
        Long saveId = memberService.join(member);

        //then
        Assertions.assertEquals(member.getId(), saveId );
    }

    @Test
    void validate() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);

        //then
        Assertions.assertThrows(IllegalStateException.class, ()-> memberService.join(member2));

        IllegalStateException e = Assertions.assertThrows(IllegalStateException.class, ()-> memberService.join(member2));
        Assertions.assertEquals(e.getMessage(), "이미 존재하는 회원입니다.");
    }

}