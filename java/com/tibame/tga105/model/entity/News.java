package com.tibame.tga105.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name = "news")
@Getter @Setter @ToString
public class News {
    @Id
    @Column(name = "news_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自動增長生成
    private Integer newsId;
    @Column(name = "news_title")
    private String newsTitle;
    @Column(name = "news_content")
    private String newsContent;
    @Column(name = "update_time")
    // 修改時自動創建時間
    @LastModifiedDate
    private Date updateTime;
    @Column(name = "news_type")
    private Integer newsType;

}
