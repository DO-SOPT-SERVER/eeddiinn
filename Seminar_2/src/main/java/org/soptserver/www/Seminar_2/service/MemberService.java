/*
  service에서는 주로 비즈니스 로직을 다룸
  특히 데이터베이스 Transaction과 관련된 처리를 담당하는 계층
  Repository 계층에 의존하여 데이터 받아오고, 도메인 계층과의 의존을 통해 데이터 가공

  이 클래스는 사용자의 정보를 조회, 생성, 수정, 삭제하는 메서드 제공
 */


package org.soptserver.www.Seminar_3.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.soptserver.www.Seminar_3.domain.Member;
import org.soptserver.www.Seminar_3.domain.SOPT;
import org.soptserver.www.Seminar_3.dto.MemberCreateRequest;
import org.soptserver.www.Seminar_3.dto.MemberGetResponse;
import org.soptserver.www.Seminar_3.dto.MemberProfileUpdateRequest;
import org.soptserver.www.Seminar_3.repository.MemberJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;

    public MemberGetResponse getMemberByIdV1(Long id) {   // 사용자 정보 조회
        Member member = memberJpaRepository.findById(id).get();
        return MemberGetResponse.of(member);
    }

    public MemberGetResponse getMemberByIdV2(Long id) {   // 사용자 정보 조회
        return MemberGetResponse.of(memberJpaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("존재하지 않는 회원입니다.")));
    }

    public List<MemberGetResponse> getMembers() {   // 모든 사용자 정보를 조회
        return memberJpaRepository.findAll()
                .stream()
                .map(MemberGetResponse::of).toList();  // 모든 사용자 정보를 가져온 후 이를 리스트로 변환하여 반환
    }

    @Transactional
    public String create(MemberCreateRequest request) {  // 새로운 사용자 정보 생성
        Member member =  memberJpaRepository.save(Member.builder()
                .name(request.name())
                .nickname(request.nickname())
                .age(request.age())
                .sopt(request.sopt())
                .build());
        return member.getId().toString();
    }

    @Transactional
    public void updateSOPT(Long memberId, MemberProfileUpdateRequest request) {  // 특정 사용자의 SOPT정보를 업데이트
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        member.updateSOPT(new SOPT(request.getGeneration(), request.getPart()));
    }

    @Transactional
    public void deleteMember(Long memberId) {  // 특정 사용자를 삭제
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        memberJpaRepository.delete(member);
    }
}