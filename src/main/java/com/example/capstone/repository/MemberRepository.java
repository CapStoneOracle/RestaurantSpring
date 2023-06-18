package com.example.capstone.repository;

import com.example.capstone.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // 이메일로 회원 정보 조회 (select * from member_table where member_email=?) 을 하고자 하는 코드
    Optional<MemberEntity> findByMemberEmail(String memberEmail);
    List<MemberEntity> findByMemberId(String memberId);

    List<MemberEntity> findByMemberName(String memberName);

}
