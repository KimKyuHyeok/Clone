package com.insta.clone.mapper;

import com.insta.clone.dto.FollowReqDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FollowMapper {
    void follow(FollowReqDTO followReqDTO);
    void unFollow(FollowReqDTO followReqDTO);
    void following(FollowReqDTO followReqDTO);
}
