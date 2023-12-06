/*
  Dto는 데이터를 전달하는 객체 역할로 클라이언트와 서버 간의 데이터 교환을 위해 사용됨
  ( 데이터는 사용자로부터 들어온 요청데이터와 서버에서 처리한 데이터를 응답해주는 응답데이터 )

  이 DTO는 새로운 사용자를 생성하기 위한 데이터를 전달하기 위해 사용됨
  즉, 클라이언트가 사용자를 생성할 때 사용자의 이름, 닉네임, 나이, sopt정보를 전송하기 위한 구조를 제공함
 */


package org.soptserver.www.Seminar_2.dto;

import org.soptserver.www.Seminar_2.domain.SOPT;
public record MemberCreateRequest(
    String name,
    String nickname,
    int age,
    SOPT sopt
) {

}
