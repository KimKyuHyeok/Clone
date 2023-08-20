package com.insta.clone.service;

import com.insta.clone.dto.UserDTO;
import com.insta.clone.mapper.AuthMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {
    private final AuthMapper authMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO principal = authMapper.findByUserLoginId(username);

        if (principal == null) {
            return null;
        } else {
            log.info("로그인 성공 : " + principal.getLoginId());
            log.info("로그인 성공 : " + principal.getPassword());

            return new PrincipalDetails(principal);
        }
    }
}
