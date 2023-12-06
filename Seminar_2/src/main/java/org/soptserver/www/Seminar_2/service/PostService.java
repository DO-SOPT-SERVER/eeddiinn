package org.soptserver.www.Seminar_3.service;

import lombok.RequiredArgsConstructor;
import org.soptserver.www.Seminar_3.repository.PostJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostJpaRepository postJpaRepository;

}

