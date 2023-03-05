package com.tibame.tga105.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name = "forum_article_report")
@Getter @Setter @ToString
public class ForumReport {
    @Id
    @Column(name = "forum_article_report_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer forumArticleReportNo;
    @Column(name = "admin_id")
    private Integer adminId;
    @Column(name = "forum_article_no")
    private Integer forumArticleNo;
    @Column(name = "member_id")
    private Integer memberId;
    @Column(name = "forum_article_report_reason_no")
    private Integer forumArticleReportReasonNo;
    @Column(name = "forum_article_report_time")
    @LastModifiedDate
    private Date forumArticleReportTime;
    @Column(name = "forum_article_report_state")
    private Integer forumArticleReportState;
    @Column(name = "forum_article_state")
    private Integer forumArticleState;

}
