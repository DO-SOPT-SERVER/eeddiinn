package dosoptserver.seminar_6.controller;


import dosoptserver.seminar_6.dto.request.ServiceMemberRequest;
import dosoptserver.seminar_6.service.ServiceMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/")
public class ServiceMemberController {

    private final ServiceMemberService serviceMemberService;

    @PostMapping("sign-up")
    public ResponseEntity<Void> signUp(@RequestBody ServiceMemberRequest request) {
        URI location = URI.create(serviceMemberService.create(request));
        return ResponseEntity.created(location).build();
    }

    @PostMapping("sign-in")
    public ResponseEntity<Void> signIn(@RequestBody ServiceMemberRequest request) {
        serviceMemberService.signIn(request);
        return ResponseEntity.noContent().build();
    }
}

