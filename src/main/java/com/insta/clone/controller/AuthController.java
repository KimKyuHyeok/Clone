package com.insta.clone.controller;

import com.insta.clone.service.PrincipalDetailService;
import com.insta.clone.util.Script;
import com.insta.clone.dto.UserJoinDTO;
import com.insta.clone.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AuthController {
    private final AuthService authService;
    private final PrincipalDetailService principalDetailService;

    @GetMapping("/auth/join")
    public String join() {
        return "/auth/joinForm";
    }

    @PostMapping("/auth/join")
    public @ResponseBody String join(UserJoinDTO userJoinDTO){
        authService.join(userJoinDTO.toSave());

        return Script.href("성공", "/auth/loginForm");
    }

    @GetMapping("/auth/loginForm")
    public String loginForm() {
        return "auth/loginForm";
    }


}
