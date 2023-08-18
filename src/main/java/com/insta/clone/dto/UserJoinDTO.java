package com.insta.clone.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserJoinDTO {
    private String username;
    private String password;
    private String email;
    private String name;

    public UserDTO toSave() {
        return UserDTO.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .build();
    }
}
