package com.insta.clone.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FollowReqDTO {
    Integer toUserId;
    Integer fromUserId;
}
