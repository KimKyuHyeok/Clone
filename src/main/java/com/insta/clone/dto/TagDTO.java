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
public class TagDTO {
    private int id;
    private String tagName;
    private int imageId;

    private ImageDTO imageDTO;

    private LocalDateTime createDate;
}
