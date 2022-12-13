package com.dokim.younghan_spring_basic.repository;

import com.dokim.younghan_spring_basic.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemberMemberRepositoryTest {

    //MemberRepository repository = new MemberMemberRepository();

    MemberMemberRepository repository = new MemberMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }


    @Test
    void save() {
        Member member = new Member();
        member.setName("dokim1");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();

        //org.junit.jupiter.api.Assertions
        Assertions.assertEquals(member, result);

        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);
    }


    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        org.assertj.core.api.Assertions.assertThat(member1).isEqualTo(result);
    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        org.assertj.core.api.Assertions.assertThat(result.size()).isEqualTo(2);
    }
}