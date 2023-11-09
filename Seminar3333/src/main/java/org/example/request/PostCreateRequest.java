package org.example.request;

public record PostCreateRequest(
        String title,
        String content
) {
}
