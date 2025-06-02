package hellospring.mavenproject.controller;

import hellospring.mavenproject.domain.Member;
import hellospring.mavenproject.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/member")
@Slf4j
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/save")
    public Member save(@RequestBody Member member) {
        log.info("Save member: {}", member);
        return memberService.save(member);
    }

    @GetMapping("/find/{id}")
    public Optional<Member> findById(@PathVariable Long id) {
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
