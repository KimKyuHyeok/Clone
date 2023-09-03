package com.insta.clone.service;

import com.insta.clone.dto.FollowReqDTO;
import com.insta.clone.mapper.FollowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FollowService {

    private final FollowMapper followMapper;

    public void following(FollowReqDTO followReqDTO) {
        followMapper.follow(followReqDTO);
    }
    public void follow(FollowReqDTO dto){
        followMapper.follow(dto);
    }

    public void unFollow(FollowReqDTO followReqDTO) {
        followMapper.unFollow(followReqDTO);
    }
}
