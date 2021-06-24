package dev.sive.untitledwebapplication.repository;

import dev.sive.untitledwebapplication.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberH2Repository implements MemberRepository {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public void save(Member member) {
        entityManager.persist(member);
    }

    @Override
    public Member findById(Long id) {
        return entityManager.find(Member.class, id);
    }

}
