package com.tibame.tga105.service;

import com.tibame.tga105.model.entity.News;

import java.util.List;

public interface NewsService {
    News createNews(News news);
    List<News> readNews();
    News readById(Integer newsId);

    void deleteById(Integer newsId);
    News updateById(Integer newsId,News news);


}
