package com.insta.clone.jwt;

import com.insta.clone.dto.UserDTO;
import com.insta.clone.mapper.AuthMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
@Slf4j
@RequiredArgsConstructor
public class JwtUserService implements UserDetailsService {
    private final AuthMapper authMapper;
    private final PasswordEncoder passwordEncoder;

//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return authMapper.findByUserLoginId(username)
//                .orElseThrow(() -> new UsernameNotFoundException("해당 유저는 존재하지 않습니다."));
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO userDTO = authMapper.findByUserLoginId(username);
        log.info("RIRIRI : " + userDTO.toString());

        if (userDTO == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username);
        } else {
            return userDTO;
        }
    }

    private UserDetails createUserDetails(UserDTO userDTO) {
        return UserDTO.builder()
                .loginId(userDTO.getEmail())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .build();
    }
}
