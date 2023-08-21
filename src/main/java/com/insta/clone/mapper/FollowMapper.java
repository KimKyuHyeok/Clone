package com.insta.clone.mapper;

public interface FollowMapper {
    void following(int toUserId, int fromUserId);
    void unFollow(int toUserId, int fromUserId);
}
