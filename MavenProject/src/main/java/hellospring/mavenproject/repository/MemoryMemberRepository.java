package hellospring.mavenproject.repository;

import hellospring.mavenproject.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(sequence++);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = store.get(id);
        if(member == null){
            return Optional.empty();
        }
        return Optional.of(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        for(Member member : store.values()){
            if(member.getName().equals(name)){
                return Optional.of(member);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
