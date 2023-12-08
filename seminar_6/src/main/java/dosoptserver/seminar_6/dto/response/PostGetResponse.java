package dosoptserver.seminar_6.dto.response;

import dosoptserver.seminar_6.domain.Post;

public record PostGetResponse(
        Long id,
        String title,
        String content
) {
    public static PostGetResponse of(Post post)
    {
        return new PostGetResponse(
                post.getId(),
                post.getTitle(),
                post.getContent()
        );
    }
}