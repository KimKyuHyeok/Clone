package com.insta.clone.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfileRespDto {
    private boolean followState; // 구독 정보
    private int followCount;
    private int imageCount;
    private UserDTO userDTO;
}
