package com.example.capstone.service;


import com.example.capstone.dto.MemberDTO;
import com.example.capstone.entity.MemberEntity;
import com.example.capstone.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    // 회원가입
    @Transactional
    public void save(MemberDTO memberDTO) {
        // 1. dto =-> entity 변환
        // 2. repository의 save 메소드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
        // repository의 save메서드 호출 (조건. entity객체를 넘겨줘야 함)
    }

    // 아이디 중복확인
    @Transactional(readOnly = true)
    public Boolean checkMemberId(String memberId) {
        if (memberRepository.findByMemberId(memberId).size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    // 별명 중복확인
    @Transactional(readOnly = true)
    public Boolean checkMemberName(String memberName) {
        if (memberRepository.findByMemberName(memberName).size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    // 회원 탈퇴
    @Transactional
    public void deleteByMemberId(String memberId){
        memberRepository.deleteByMemberId(memberId);
    }

    // 로그인 정보 확인 후 로그인
    @Transactional(readOnly = true)
    public Boolean checkLogin(String memberId, String memberPassword) {
        if (memberRepository.findByMemberIdAndMemberPassword(memberId, memberPassword).size() != 0) {
            return true;
        } else {
            return false;
        }
    }

    // 닉네임 수정
    @Transactional
    public void changeMemberName(String memberId, String memberName){
        List<MemberEntity> member = memberRepository.findByMemberId(memberId);
        member.get(0).setMemberName(memberName);
        memberRepository.save(member.get(0));
    }

    // 이메일 수정
    @Transactional
    public void changeMemberEmail(String memberId, String memberEmail){
        List<MemberEntity> member = memberRepository.findByMemberId(memberId);
        member.get(0).setMemberEmail(memberEmail);
        memberRepository.save(member.get(0));
    }

    // 비밀번호 수정
    @Transactional
    public void changeMemberPassword(String memberId, String memberPassword){
        List<MemberEntity> member = memberRepository.findByMemberId(memberId);
        member.get(0).setMemberPassword(memberPassword);
        memberRepository.save(member.get(0));
    }

    // 멤버 Id로 해당 멤버 찾기
    @Transactional(readOnly = true)
    public List<MemberEntity> findById(String memberId){
        return memberRepository.findByMemberId(memberId);
    }

    // 멤버 email로 아이디 찾기
    @Transactional(readOnly = true)
    public MemberEntity findByMemberEmail(String memberEmail) {
        return memberRepository.findByMemberEmail(memberEmail);
    }

    // 비밀번호 찾기에서 멤버 ID와 멤버 email로 찾기
    @Transactional(readOnly = true)
    public MemberEntity findByMemberIdAndMemberEmail(String memberId, String memberEmail){
        return memberRepository.findByMemberIdAndMemberEmail(memberId, memberEmail);
    }
}
