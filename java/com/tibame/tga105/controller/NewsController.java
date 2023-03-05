package com.tibame.tga105.controller;

import com.tibame.tga105.model.entity.News;
import com.tibame.tga105.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    //後台最新消息頁面(讀取資料庫)
    @RequestMapping("/24admin.news.html")
    public String getAll(Model model){
        model.addAttribute("newsList",newsService.readNews());
        return "24admin.news";
    }

    //前台首頁最新消息(讀取資料庫)
    @GetMapping  ("/24front_page.html")
    public String getNews(Model model){
        model.addAttribute("news", newsService.readNews());
        return "24front_page";
    }

    //後台編輯最新消息
    @GetMapping("/24admin.news_edit.html")
    public String getNewsById(Integer newsId, Model model) throws ChangeSetPersister.NotFoundException {
        News news1 = newsService.readById(newsId);
        if(news1 != null){
            model.addAttribute("news1",news1);
            return "24admin.news_edit";
        }else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    @PostMapping("/update")
    public String updateNews(News news){
        newsService.updateById(news.getNewsId(), news);
        return "redirect:/24admin.news.html";
    }

}




