package com.insta.clone.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
public class ImageReqDTO {

    private MultipartFile files;
    private String caption;
    private String tags;
}
