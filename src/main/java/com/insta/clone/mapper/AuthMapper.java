package com.insta.clone.mapper;

import com.insta.clone.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {
    void join(UserDTO userDTO);
    UserDTO findByUserLoginId(String userLoginId);
}
