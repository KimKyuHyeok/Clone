package com.insta.clone.service;

import com.insta.clone.dto.LoginDTO;
import com.insta.clone.dto.TokenDTO;
import com.insta.clone.dto.UserDTO;
import com.insta.clone.exception.LoginFailedException;
import com.insta.clone.jwt.JwtTokenProvider;
import com.insta.clone.mapper.AuthMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final AuthMapper authMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public void join(UserDTO userDTO) {
        String rawPassword = userDTO.getPassword();
        String encPassword = passwordEncoder.encode(rawPassword);

        userDTO.setPassword(encPassword);
        userDTO.setRole("USER");
        authMapper.join(userDTO);
    }

    public UserDTO getUserInfo(String loginUserId) {
        return authMapper.findByUserLoginId(loginUserId);
    }

    public String login(LoginDTO loginDTO) {
        if(authMapper.findByUserLoginId(loginDTO.getUsername()) == null){
            throw new LoginFailedException("잘못된 아이디 입니다.");
        }

        UserDTO userDTO = authMapper.findByUserLoginId(loginDTO.getUsername());

        if (!passwordEncoder.matches(loginDTO.getPassword(), userDTO.getPassword())) {
            throw new LoginFailedException("잘못된 비밀번호 입니다.");
        }

        return userDTO.getLoginId();
    }

    public TokenDTO tokenGenerator(String userEmail) {

        String accessToken = jwtTokenProvider.createAccessToken(userEmail);
        String refreshToken = jwtTokenProvider.createRefreshToken(userEmail);

        return TokenDTO.builder()
                .accessToken("Bearer " + accessToken)
                .refreshToken("Bearer " + refreshToken)
                .build();
    }
}
