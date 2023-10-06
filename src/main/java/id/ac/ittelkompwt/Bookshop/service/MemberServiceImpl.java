package id.ac.ittelkompwt.Bookshop.service;

import id.ac.ittelkompwt.Bookshop.constant.ResponseMessage;
import id.ac.ittelkompwt.Bookshop.entity.Member;
import id.ac.ittelkompwt.Bookshop.exception.DataNotFoundException;
import id.ac.ittelkompwt.Bookshop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override // done
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member getMemberById(String memberId) {
        verify(memberId);
        return memberRepository.findById(memberId).get();
    }

    @Override //done
    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    @Override // done
    public Member updateMember(Member member) {
        verify(member.getMemberId());
        return memberRepository.save(member);
    }

    @Override
    public void deleteMember(String memberId) {
        verify(memberId);
        memberRepository.deleteById(memberId);
    }

    private void verify(String id) {
        if(!memberRepository.findById(id).isPresent()) {
            String message = String.format(ResponseMessage.NOT_FOUND_MESSAGE, "member ", id);
            throw new DataNotFoundException(message);
        }
    }
}
