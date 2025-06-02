package hellospring.mavenproject.service;

import hellospring.mavenproject.domain.Member;
import hellospring.mavenproject.repository.MemberRepository;
import hellospring.mavenproject.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemoryMemberRepository memoryMemberRepository;

    public MemberService(MemoryMemberRepository memoryMemberRepository) {
        this.memoryMemberRepository = memoryMemberRepository;
    }

    public Member save(Member member) {
        return memoryMemberRepository.save(member);
    }


    public Optional<Member> findById(Long id) {
        return memoryMemberRepository.findById(id);
    }

    public Optional<Member> findByName(String name) {
        return memoryMemberRepository.findByName(name);
    }

    public List<Member> findAll() {
        return memoryMemberRepository.findAll();
    }
}
