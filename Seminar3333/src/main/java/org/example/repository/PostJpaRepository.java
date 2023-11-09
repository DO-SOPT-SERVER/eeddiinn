package org.example.repository;

import org.example.domain.Member;
import org.example.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostJpaRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByMemberId(Long memberId);

    List<Post> findAllByMember(Member member);
}