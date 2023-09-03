package com.insta.clone.controller;

import com.insta.clone.dto.*;
import com.insta.clone.mapper.AuthMapper;
import com.insta.clone.service.ImageService;
import com.insta.clone.util.Script;
import com.insta.clone.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AuthController {

    private final AuthService authService;
    private final ImageService imageService;

    @GetMapping("/auth/joinForm")
    public String join() {
        return "/auth/joinForm";
    }

    @PostMapping("/auth/joinForm")
    public @ResponseBody String join(UserDTO userDTO){
        authService.join(userDTO);

        return Script.href("성공", "/auth/loginForm");
    }

    @GetMapping("/auth/loginForm")
    public String loginForm() {
        return "/auth/loginForm";
    }


    @GetMapping("/user/{userId}")
    public String userMyPage(@PathVariable int userId, @AuthenticationPrincipal UserDTO userDTO, Model model) {
        List<ImageDTO> images = imageService.feedImage(userDTO.getLoginId());
        model.addAttribute("userInfo", userDTO);
        model.addAttribute("images", images);

        return "/auth/profile";
    }



}
