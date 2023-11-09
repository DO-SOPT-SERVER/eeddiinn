package org.soptserver.www.Seminar_3.repository;

import org.soptserver.www.Seminar_3.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepository extends JpaRepository<Post, Long>{
}
