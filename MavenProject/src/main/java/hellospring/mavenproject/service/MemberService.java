package hellospring.mavenproject.service;

import hellospring.mavenproject.domain.Member;
import hellospring.mavenproject.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member save(Member member) {
        return memberRepository.save(member);
    }


    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    public Optional<Member> findByName(String name) {
        return memberRepository.findByName(name);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}
