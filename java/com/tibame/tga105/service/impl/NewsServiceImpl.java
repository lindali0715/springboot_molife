package com.tibame.tga105.service.impl;

import com.tibame.tga105.model.dao.NewsRepository;
import com.tibame.tga105.model.entity.News;
import com.tibame.tga105.model.entity.PostInfo;
import com.tibame.tga105.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public News createNews(News news) {
        return newsRepository.save(news);
    }

    @Override
    public List<News> readNews() {
        return newsRepository.findAll();
    }

    @Override
    public News readById(Integer newsId) {
        return newsRepository.getByNewsId(newsId);
    }

    @Override
    public void deleteById(Integer newsId) {
        newsRepository.deleteById(newsId);
    }

    @Override
    public News updateById(Integer newsId,News news) {
        News news1 = newsRepository.findById(newsId).get();
        if(news1 != null){
            news1.setNewsTitle(news.getNewsTitle());
            news1.setNewsContent(news.getNewsContent());
            news1.setNewsType(news.getNewsType());
            news1.setUpdateTime(new Date());
            news1.setNewsId(newsId);
        }
        return newsRepository.save(news1);
    }


}
