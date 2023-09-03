//package com.insta.clone.service;
//
//import com.insta.clone.dto.UserDTO;
//import com.insta.clone.mapper.AuthMapper;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class PrincipalDetailService implements UserDetailsService {
//    private final AuthMapper authMapper;
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserDTO principal = authMapper.findByUserLoginId(username);
//
//        if (principal == null) {
//            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username);
//        } else {
//            log.info("로그인 성공 : " + principal.getLoginId());
//            log.info("로그인 성공 : {}", principal.getLoginId());
//
//            return new CustomUser(principal,
//                    getAuthorities(principal.getRole()));
//        }
//    }
//
//    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(role));
//        return authorities;
//    }
//}
