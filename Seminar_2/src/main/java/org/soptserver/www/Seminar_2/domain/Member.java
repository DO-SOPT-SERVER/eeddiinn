/*
만들 product를 구성하고 있는 요소 = Domain
 */


package org.soptserver.www.Seminar_2.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity    // JPA 엔티티 클래스임을 나타냄
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class

Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // Id필드가 데이터베이스의 기본 키 역할을 함
    private Long id;
    private String name;
    private String nickname;
    private int age;

    @Embedded
    private SOPT sopt;
    // SOPT 클래스를 내장 엔티티로 사용함
    // 내장 엔티티 : 하나의 엔티티 클래스에서 다른 엔티티 클래스를 포함하고 그 포함된 엔티티를 별도의 테이블로 저장하는 방식

    @Builder
    public Member(String name, String nickname, int age, SOPT sopt) {
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.sopt = sopt;
    }

    public void updateSOPT(SOPT sopt)  // 새로운 SOPT객체를 받아서 Member객체의 sopt필드를 업데이트 함
    {
        this.sopt = sopt;
    }
}