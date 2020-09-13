package com.example.search2.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.search2.domains.Member;

@Mapper
public interface MemberMapper {
    List<Member> all();
    List<Member>findByNameLike(String words);
    void add(Member member);
}