package org.soptserver.www.Seminar_3.controller;

import lombok.RequiredArgsConstructor;
import org.soptserver.www.Seminar_3.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/post")
public class PostController {

    private static final String CUSTOM_AUTH_ID = "X-Auth-Id";
    private final PostService postService;

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestHeader(CUSTOM_AUTH_ID) Long memberId,
                                           @RequestBody PostCreateRequest request) {
        URI location = URI.create("/api/post/" + postService.create(request, memberId));
        return ResponseEntity.created(location).build();
    }
}

}
