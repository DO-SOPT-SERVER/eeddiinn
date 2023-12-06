package org.example.repository;

import org.example.domain.Member;
import jakarta.persistence.EntityNotFoundException;
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

