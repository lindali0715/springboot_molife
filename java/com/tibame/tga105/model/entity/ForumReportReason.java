package com.tibame.tga105.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "forum_article_report_reason")
@Getter @Setter @ToString
public class ForumReportReason {
    @Id
    @Column(name = "forum_article_report_reason_no")
    private Integer forumArticleReportReasonNo;
    @Column(name = "forum_article_report_reason_contain")
    private String forumArticleReportReasonContain;
}
