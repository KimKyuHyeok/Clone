//package com.insta.clone.controller;
//
//import com.insta.clone.dto.FollowReqDTO;
//import com.insta.clone.service.FollowService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@RequiredArgsConstructor
//@Controller
//@RequestMapping("/follow")
//public class FollowController {
//    private final FollowService followService;
//
//    @PostMapping("/{toUserId}")
//    public void follow(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable("toUserId") int toUserId) {
//        FollowReqDTO followReqDTO = FollowReqDTO.builder()
//                .toUserId(toUserId)
//                .fromUserId(principalDetails.getUserDTO().getUserId())
//                .build();
//        followService.following(followReqDTO);
//    }
//
//    @DeleteMapping("/{toUserId}")
//    public void unFollow(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable("toUserId") int toUserId) {
//        FollowReqDTO followReqDTO = FollowReqDTO.builder()
//                .toUserId(toUserId)
//                .fromUserId(principalDetails.getUserDTO().getUserId())
//                .build();
//        followService.unFollow(followReqDTO);
//    }
//}
