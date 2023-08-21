package com.insta.clone.controller;

import com.insta.clone.service.FollowService;
import com.insta.clone.service.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/follow")
public class FollowController {
    private final FollowService followService;

    @PostMapping("/{toUserId}")
    public void follow(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable("toUserId") int toUserId) {
        int fromUserId = principalDetails.getUserDTO().getUserId();
        followService.following(toUserId, fromUserId);
    }

    @DeleteMapping("/{toUserId}")
    public void unFollow(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable("toUserId") int toUserId) {
        int fromUserId = principalDetails.getUserDTO().getUserId();
        followService.unFollow(toUserId, fromUserId);
    }
}
