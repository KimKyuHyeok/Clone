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
public class CommentDTO {
    private int id;
    private String comment;
    private int imageId;
    private int userId;
    private LocalDateTime createDate;
}
