/* enum(열거형)은 연관된 상수 값의 집합을 나타내는 자료형 */

package org.example.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Part {
    SERVER("서버"),
    WEB("웹"),
    ANDROID("안드로이드"),
    IOS("iOS"),
    PLAN("기획"),
    DESIGN("디자인");

    private final String name;
}

