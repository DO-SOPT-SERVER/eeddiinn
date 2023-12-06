/*
  이 Dto는 클라이언트가 사용자의 SOPT 정보를 업데이트 할 때 전송하는 데이터를 나타냄
 */

package org.soptserver.www.Seminar_2.dto;

import lombok.Data;
import org.soptserver.www.Seminar_2.domain.Part;

@Data
public class MemberProfileUpdateRequest {
    private int generation;
    private Part part;
}
