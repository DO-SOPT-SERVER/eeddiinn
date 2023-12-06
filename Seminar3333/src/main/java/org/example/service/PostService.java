package org.example.service;

import org.example.domain.Member;
import org.example.domain.Post;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.example.repository.MemberJpaRepository;
import org.example.repository.PostJpaRepository;
import org.example.request.PostCreateRequest;
import org.example.request.PostUpdateRequest;
import org.example.response.PostGetResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostJpaRepository postJpaRepository;
    private final MemberJpaRepository memberJpaRepository;

    @Transactional
    public String create(PostCreateRequest request, Long memberId)
    {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        Post post = postJpaRepository.save(
                Post.builder()
                        .member(member)
                        .title(request.title())
                        .content(request.content()).build());
        return post.getPostId().toString();
    }
    @Transactional
    public void editContent(Long postId, PostUpdateRequest request) {
        Post post = postJpaRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
        post.updqteContent(request.conetent());
    }

    @Transactional
    public void deleteById(Long postId) {
        Post post = postJpaRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
        postJpaRepository.delete(post);
    }

    public List<PostGetResponse> getPosts(Long memberId) {
        return postJpaRepository.findAllByMemberId(memberId)
                .stream()
                .map(post -> PostGetResponse.of(post))
                .toList();
    }

    public PostGetResponse getById(Long postId) {
        Post post = postJpaRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
        return PostGetResponse.of(post);
    }
}