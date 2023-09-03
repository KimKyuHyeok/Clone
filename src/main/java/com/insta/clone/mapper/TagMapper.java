package com.insta.clone.mapper;

import com.insta.clone.dto.TagDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagMapper {
    void upload(TagDTO tagDTO);
}
