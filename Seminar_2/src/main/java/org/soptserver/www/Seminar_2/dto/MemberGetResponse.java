/*
  이 Dto는 Member 엔티티의 정보를 클라이언트에 반환하는데 사용
 */

package org.soptserver.www.Seminar_3.dto;

import org.soptserver.www.Seminar_3.domain.Member;
import org.soptserver.www.Seminar_3.domain.SOPT;
public record MemberGetResponse(
        String name,
        String nickname,
        int age,
        SOPT soptInfo

) {
    public static MemberGetResponse of(Member member)
    {
        return new MemberGetResponse(
                member.getName(),
                member.getNickname(),
                member.getAge(),
                member.getSopt()
        );
    }
}
