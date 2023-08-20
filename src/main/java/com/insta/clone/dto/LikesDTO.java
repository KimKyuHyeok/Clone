package com.insta.clone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LikesDTO {
    private int id;
    private ImageDTO imageDTO;
    private UserDTO userDTO;
    private LocalDateTime createDate;
}
