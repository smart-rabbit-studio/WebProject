package hellospring.mavenproject.controller;

import hellospring.mavenproject.domain.Member;
import hellospring.mavenproject.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/save")
    public Member save(@RequestBody Member member) {
        return memberService.save(member);
    }

    @GetMapping("/find")
    public Optional<Member> findById(@RequestParam(value = "id") Long id) {
        return memberService.findById(id);
    }

    @GetMapping("/find")
    public Optional<Member> findByName(@RequestParam(value = "name") String name) {
        return memberService.findByName(name);
    }

    @GetMapping("/findAll")
    public List<Member> findAll() {
        return memberService.findAll();
    }
}
