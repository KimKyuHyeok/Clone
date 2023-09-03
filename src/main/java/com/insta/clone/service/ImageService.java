package com.insta.clone.service;

import com.insta.clone.dto.ImageDTO;
import com.insta.clone.dto.ImageReqDTO;
import com.insta.clone.dto.TagDTO;
import com.insta.clone.dto.UserDTO;
import com.insta.clone.mapper.AuthMapper;
import com.insta.clone.mapper.FollowMapper;
import com.insta.clone.mapper.ImageMapper;
import com.insta.clone.mapper.TagMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageMapper imageMapper;
    private final AuthMapper authMapper;
    private final TagMapper tagMapper;
    private final FollowMapper followMapper;

    //TODO: 이걸 절대경로로 바꿔주자 !
    private final static String PATH = "/Users/kyuhyeokmac/Downloads/clone/src/main/webapp/static/upload";

    // 팔로우 한 사람들 이미지 가져오기
    public List<ImageDTO> feedImage(String userLoginId) {
        int userId = 0;
        UserDTO userDTO = authMapper.findByUserLoginId(userLoginId);
        if (userDTO != null) {
            userId = userDTO.getUserId();
        }

        List<ImageDTO> imageDTOList = new ArrayList<>();
        List<Integer> toUserId = imageMapper.feedImage(userId);

        for (Integer user : toUserId) {
            List<ImageDTO> imageDTOS = imageMapper.imageList(user);

            for (ImageDTO use : imageDTOS) {
                UserDTO userInfo = authMapper.userIdByInfo(user);

                use.setUserInfo(userInfo);
                imageDTOList.add(use);
            }
        }

        return imageDTOList;
    }

    //이미지 업로드
    public void upload(ImageReqDTO imageReqDTO, UserDTO userDTO) throws IOException {
        String originalFileName = imageReqDTO.getFiles().getOriginalFilename();
        String saveFileName = UUID.randomUUID().toString().substring(0, 5) + "_" + originalFileName;


        ImageDTO imageDTO = ImageDTO.builder()
                .content(imageReqDTO.getCaption())
                .postImageUrl(saveFileName)
                .originalFileName(originalFileName)
                .userId(userDTO.getUserId())
                .tagName(imageReqDTO.getTags())
                .userInfo(userDTO)
                .build();

        imageMapper.upload(imageDTO);

        File saveInPath = new File(PATH, saveFileName);
        imageReqDTO.getFiles().transferTo(saveInPath);

        // 태그 등록
        String[] tagList = imageReqDTO.getTags().split(" ");
        for (String tag : tagList) {
            TagDTO tagDTO = TagDTO.builder()
                    .tagName(tag)
                    .imageId(imageDTO.getId())
                    .build();

            tagMapper.upload(tagDTO);
        }
    }

    public String findUploader(Integer userId) {
        return authMapper.userIdByInfo(userId).getName();
    }
}
