package dosoptserver.seminar_6.repository;

import dosoptserver.seminar_6.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Member;
import java.util.List;

public interface PostJpaRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByMemberId(Long memberId);

    List<Post> findAllByMember(Member member);
}
