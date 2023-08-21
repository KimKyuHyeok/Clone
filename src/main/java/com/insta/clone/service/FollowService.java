package com.insta.clone.service;

import com.insta.clone.mapper.FollowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FollowService {

    private final FollowMapper followMapper;

    public void following(int toUserId, int fromUserId) {
        followMapper.following(toUserId, fromUserId);
    }

    public void unFollow(int toUserId, int fromUserId) {
        followMapper.unFollow(toUserId, fromUserId);
    }
}
