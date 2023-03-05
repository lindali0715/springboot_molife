package com.tibame.tga105.service;

import com.tibame.tga105.model.entity.PostInfo;

import java.util.List;

public interface PostInfoService {
    PostInfo createInfo(PostInfo postInfo);
    List<PostInfo> readInfo();
    PostInfo readById(Integer infoId);
    void deleteById(Integer infoId);
    PostInfo updateById(Integer infoId, PostInfo postInfo);
}
