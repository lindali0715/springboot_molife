package com.tibame.tga105.model.dao;

import com.tibame.tga105.model.entity.News;
import com.tibame.tga105.model.entity.PostInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostInfoRepository extends JpaRepository<PostInfo,Integer> {

    List<PostInfo> findAll();
    void deleteById(Integer infoId);

    @Override
    Optional<PostInfo> findById(Integer infoId);

    @Query(value = "select * from post_info where info_id = ?", nativeQuery = true)
    PostInfo getByInfoId(Integer infoId);

}
