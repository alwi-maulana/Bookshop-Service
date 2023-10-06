package id.ac.ittelkompwt.Bookshop.controller;

import id.ac.ittelkompwt.Bookshop.entity.Member;
import id.ac.ittelkompwt.Bookshop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }
//    , @RequestHeader String header

    @GetMapping("/{memberId}")
    public Member getMemberById(@PathVariable String memberId) {
        return  memberService.getMemberById(memberId);
    }

    @GetMapping
    public List<Member> getAllMember() {
        return memberService.getAllMember();
    }

    @PutMapping
    public Member updateMember(@RequestBody Member member) {
        return  memberService.updateMember(member);

    }

    @DeleteMapping("/{memberId}")
    public void deteleMember(@PathVariable String memberId) {
        memberService.deleteMember(memberId);
    }
}


