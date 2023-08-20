package com.insta.clone.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserJoinDTO {
    private String userLoginId;
    private String password;
    private String email;
    private String name;

    public UserDTO toSave() {
        return UserDTO.builder()
                .loginId(userLoginId)
                .password(password)
                .email(email)
                .name(name)
                .build();
    }
}
