/* Repository는 데이터 베이스와 직접적으로 연결되는 계층
   Repository 계층을 통해서만 데이터베이스와 통신하기 때문데 안정적으로 관리 가능

   MemberJpaRepository 인터페이스를 사용하면 데이터 베이스에서
   Member 엔티티를 조회하고, 필요한 경우 예외처리를 할 수 있음
 */

package org.soptserver.www.Seminar_2.repository;

import jakarta.persistence.EntityNotFoundException;
import org.soptserver.www.Seminar_2.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    default Member findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(
                        () -> new EntityNotFoundException("존재하지 않는 회원입니다."));

        /*findById 메서드는 데이터베이스에서 엔티티를 조회하는 역할
          orElseThrow 메서드는 엔티티가 데이터 베이스에서 찾아지지 않을 경우 예외 발생시킴
         */

    }
}
