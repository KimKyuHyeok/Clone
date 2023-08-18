package com.insta.clone.controller;

import com.insta.clone.config.Script;
import com.insta.clone.dto.UserJoinDTO;
import com.insta.clone.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class AuthController {
    private final AuthService authService;

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
