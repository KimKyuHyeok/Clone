package com.insta.clone.controller;

import com.insta.clone.dto.CommentDTO;
import com.insta.clone.dto.ImageDTO;
import com.insta.clone.dto.ImageReqDTO;
import com.insta.clone.dto.UserDTO;
import com.insta.clone.service.AuthService;
import com.insta.clone.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ImageController {

    private final ImageService imageService;
    private final AuthService authService;

    @GetMapping({"/", "/image/feed"})
    public String feed(Model model, @AuthenticationPrincipal UserDTO userDTO) {

        List<ImageDTO> imageDTOList = imageService.feedImage(userDTO.getLoginId());

        model.addAttribute("images", imageDTOList);

        return "/image/feed";
    }

    @GetMapping("/image/upload")
    public String upload() {
        return "/image/upload";
    }


    @PostMapping("/image")
    public String uploadImage(ImageReqDTO imageReqDTO, @AuthenticationPrincipal UserDTO userDTO) throws IOException {

        imageService.upload(imageReqDTO, userDTO);

        return "redirect:/image/feed";
    }
}
