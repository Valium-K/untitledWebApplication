package dev.sive.untitledwebapplication.repository;

import dev.sive.untitledwebapplication.domain.Member;

import java.util.List;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long id);
    List<Member> findAll();
}
