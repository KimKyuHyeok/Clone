//package com.insta.clone.service;
//
//import com.insta.clone.dto.UserDTO;
//import com.insta.clone.mapper.AuthMapper;
//import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//@Data
//public class PrincipalDetails implements UserDetails{
//    private UserDTO userDTO;
//
//    public PrincipalDetails(UserDTO userDTO) {
//        this.userDTO = userDTO;
//    }
//
//    @Override
//    public String getPassword() {
//        return userDTO.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return userDTO.getLoginId();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//
//        //해당 User 의 권한을 리턴하는 곳 getRole 을 바로 return 할수 없음
//        Collection<GrantedAuthority> collectors = new ArrayList<>(); // 자바 유틸꺼임, collectors 에 권한을 넣어줘야함
//        collectors.add(()-> "ROLE_"+ userDTO.getRole().toString()); // collectors 에 리턴되서 들어간다.
//        //컬렉터에 GrantedAuthority 타입을 넣어줘야한다.
//
//
//
//        return collectors;
//    }
//}