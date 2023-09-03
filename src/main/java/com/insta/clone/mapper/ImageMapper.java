package com.insta.clone.mapper;

import com.insta.clone.dto.ImageDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImageMapper {
    List<Integer> feedImage(int fromUserId);
    List<ImageDTO> imageList(int userId);
    void upload(ImageDTO imageDTO);
}
