package com.example.capstone.repository;

import com.example.capstone.dto.MemberDTO;
import com.example.capstone.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // 멤버 ID로 찾기
    List<MemberEntity> findByMemberId(String memberId);

    // 멤버 Name으로 찾기
    List<MemberEntity> findByMemberName(String memberName);

    // 멤버 ID랑Password로 찾기
    List<MemberEntity> findByMemberIdAndMemberPassword(String memberId, String memberPassword);

    // 멤버 ID로 삭제
    List<MemberEntity> deleteByMemberId(String memberId);

    MemberEntity findByMemberEmail(String memberEmail);

    MemberEntity findByMemberIdAndMemberEmail(String memberId, String memberEmail);

}
