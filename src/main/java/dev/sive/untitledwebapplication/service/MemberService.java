package dev.sive.untitledwebapplication.service;

import dev.sive.untitledwebapplication.domain.Member;
import dev.sive.untitledwebapplication.repository.MemberH2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberH2Repository memberRepository;

    @Transactional
    public Long join(Member member) {
        memberRepository.save(member);

        return member.getId();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
