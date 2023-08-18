package com.insta.clone.service;

import com.insta.clone.dto.UserDTO;
import com.insta.clone.dto.UserJoinDTO;
import com.insta.clone.mapper.AuthMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final AuthMapper authMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void join(UserDTO userDTO) {
        String rawPassword = userDTO.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);

        userDTO.setPassword(encPassword);
        userDTO.setRole("USER");
        authMapper.join(userDTO);
    }
}
