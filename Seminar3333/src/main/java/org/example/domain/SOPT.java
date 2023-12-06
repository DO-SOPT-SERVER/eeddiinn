package org.example.domain;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Embeddable;

@Embeddable   // 이 클래스가 다른 엔티티 클래스에 내장되는 객체임을 나타냄
@Getter
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SOPT{
    private int generation;

    @Enumerated(value = EnumType.STRING)
    private Part part;
}
