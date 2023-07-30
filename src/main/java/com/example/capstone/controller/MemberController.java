package com.example.capstone.controller;

import com.example.capstone.dto.MemberDTO;
import com.example.capstone.entity.MemberEntity;
import com.example.capstone.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    // 생성자 주입
    private final MemberService memberService;

    // 회원가입
    @PostMapping("/member/save")
    public ResponseEntity<MemberDTO> save(@RequestBody MemberDTO memberDTO) {
        System.out.println("MemberController.save");
        System.out.println("memberDTO = " + memberDTO);
        memberService.save(memberDTO);
        return ResponseEntity.ok(memberDTO);
    }

    // 로그인 정보 맞는지 확인
    @PostMapping("/login")
    public Boolean checkLogin(@RequestParam("id") String memberId, @RequestParam("password")String memberPassword) {
        System.out.println("checkLogin() 입장");
        return memberService.checkLogin(memberId, memberPassword);
    }

    // ID 중복확인
    @GetMapping("/check/id")
    public ResponseEntity<Boolean> checkMemberId(@RequestParam("id") String memberId) {
        return ResponseEntity.ok(memberService.checkMemberId(memberId));
    }

    // 닉네임 중복확인
    @GetMapping("/check/name")
    public ResponseEntity<Boolean> checkMemberName(@RequestParam("name") String memberName) {
        return ResponseEntity.ok(memberService.checkMemberName(memberName));
    }

    // 회원 탈퇴
    @DeleteMapping("/delete")
    public void deleteByName(@RequestParam("id") String memberId){
        memberService.deleteByMemberId(memberId);
    }

    // 닉네임 수정
    @PutMapping("/change/name")
    public void changeMemberName(@RequestParam("id") String memberId, @RequestParam("name") String memberName){
        memberService.changeMemberName(memberId, memberName);
    }

    // 이메일 수정
    @PutMapping("/change/email")
    public void changeMemberEmail(@RequestParam("id") String memberId, @RequestParam("email") String memberEmail){
        memberService.changeMemberEmail(memberId, memberEmail);
    }

    // 비밀번호 수정
    @PutMapping("/change/password")
    public void changeMemberPassword(@RequestParam("id") String memberId, @RequestParam("password") String memberPassword){
        memberService.changeMemberPassword(memberId, memberPassword);
    }

    // 해당 멤버 ID의 정보 가져오기
    @GetMapping("/find/id")
    public ResponseEntity<List<MemberEntity>> findById(@RequestParam("id") String memberId){
        return ResponseEntity.ok(memberService.findById(memberId));
    }

    // 아이디 찾기 할 때 이메일을 통해 찾는다.
    @GetMapping("find/email")
    public ResponseEntity<MemberEntity> findBymemberEmail(@RequestParam("email") String memberEmail){
        return ResponseEntity.ok(memberService.findByMemberEmail(memberEmail));
    }

    // 비밀번호 찾기 할 때 멤버ID, 이메일로 찾기
    @GetMapping("find/password")
    public ResponseEntity<MemberEntity> findByMemberIdAndMemberEmail(@RequestParam("id") String memberId, @RequestParam("email") String memberEmail) {
        return ResponseEntity.ok(memberService.findByMemberIdAndMemberEmail(memberId, memberEmail));
    }
}
