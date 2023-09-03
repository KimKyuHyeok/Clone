package com.insta.clone.service;

import com.insta.clone.dto.UserDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
public class CustomUser extends User {
    private int userId;
    private UserDTO userDTO;

    public CustomUser(UserDTO userDTO,
                      Collection<? extends GrantedAuthority> authorities) {
        super(userDTO.getLoginId(), userDTO.getPassword(), authorities);
        this.userId = userDTO.getUserId();
        this.userDTO = userDTO;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
