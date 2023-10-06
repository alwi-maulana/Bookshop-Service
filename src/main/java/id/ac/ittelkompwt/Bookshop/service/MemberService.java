package id.ac.ittelkompwt.Bookshop.service;

import id.ac.ittelkompwt.Bookshop.entity.Member;

import java.util.List;

public interface MemberService {

    public Member addMember(Member member);

    public Member getMemberById(String memberId);

    public List<Member> getAllMember();

    public Member updateMember(Member member);

    public void deleteMember(String memberId);

}
