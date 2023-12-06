/*
Client에서 보내는 HTTP 요청을 받아 Service 계층에 전달해주고,
Service 계층에서 처리한 응답을 처리 해주는 Class !!

Controller임을 나타내기 위해서 class위에 `@RestController` Annotation을 붙임


`@RestController` = `@Controller` + `@ResponseBody`
 */


package org.soptserver.www.Seminar_3.controller;

import lombok.RequiredArgsConstructor;
import org.soptserver.www.Seminar_3.dto.MemberCreateRequest;
import org.soptserver.www.Seminar_3.dto.MemberGetResponse;
import org.soptserver.www.Seminar_3.dto.MemberProfileUpdateRequest;
import org.soptserver.www.Seminar_3.service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/member")      //  /api/member 경로로 들어오는 HTTP 요청을 이 클래스에서 처리한다고 선언
@RequiredArgsConstructor

public class MemberController {

    private final MemberService memberService;

    // 특정 사용자 정보 단건 조회 V1
    @GetMapping("/{memberId}/v1")
    public ResponseEntity<MemberGetResponse>
    getMemberProfileV1(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.getMemberByIdV2(memberId));
    }

    // 특정 사용자 정보 단건 조회 V2
    @GetMapping(value = "/{memberId}/v2", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemberGetResponse>
    getMemberProfileV2(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.getMemberByIdV2(memberId));
    }


    // 목록 조회
    @GetMapping
    public ResponseEntity<List<MemberGetResponse>> getMembersProfile() {
        return ResponseEntity.ok(memberService.getMembers());
    }

    // 생성
    @PostMapping
    public ResponseEntity<Void> createMember(@RequestBody MemberCreateRequest request) {
        URI location =  URI.create("api/member/" + memberService.create(request));
        return ResponseEntity.created(location).build();
    }

    // 수정
    @PatchMapping("/{memberId}")
    public ResponseEntity<Void> updateMemberSoptInfo(@PathVariable Long memberId, @RequestBody MemberProfileUpdateRequest request) {
        memberService.updateSOPT(memberId, request);
        return ResponseEntity.noContent().build();
    }

    // 삭제
    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }
}