package dev.sive.untitledwebapplication.repository;

import dev.sive.untitledwebapplication.domain.Member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long id);
}
