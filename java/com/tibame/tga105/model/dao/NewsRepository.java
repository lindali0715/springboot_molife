package com.tibame.tga105.model.dao;


import com.tibame.tga105.model.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NewsRepository extends JpaRepository<News,Integer> {

    List<News> findAll();
    void deleteById(Integer newsId);

    @Override
    Optional<News> findById(Integer newsId);

    @Query(value = "select * from news where news_id = ?", nativeQuery = true)
    News getByNewsId(Integer newsId);

}
