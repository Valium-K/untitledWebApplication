package dev.sive.untitledwebapplication.repository;

import dev.sive.untitledwebapplication.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Override
    public List<Member> findAll() {
        String qlString = "select m from Member as m";
        return entityManager.createQuery(qlString, Member.class).getResultList();
    }

    @Override
    public Member findByName(String name) {
        Member foundMember = entityManager.createQuery("select m from Member as m where m.name=:name", Member.class)
                .setParameter("name", name)
                .getSingleResult();

        return foundMember;
    }
}
