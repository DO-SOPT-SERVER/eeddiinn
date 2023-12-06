package semina.semina.dto.resource;

import org.springframework.format.annotation.DateTimeFormat;

@DateTimeFormat

public class MemberCreateRequest {

        private String name;
        private String nickname;
        private int age;
        private SOPT sopt;
    }

}
