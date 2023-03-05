package com.tibame.tga105.model.dao;

import com.tibame.tga105.model.entity.ContactUs;
import com.tibame.tga105.model.entity.ForumReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ForumReportRepository extends JpaRepository<ForumReport,Integer> {
    List<ForumReport> findAll();

    void deleteById(Integer forumArticleReportNo);
    @Override
    Optional<ForumReport> findById(Integer forumArticleReportNo);

    @Query(value = "select * from forum_article_report where forum_article_report_no = ?", nativeQuery = true)
    ForumReport getByReportId(Integer forumArticleReportNo);
}
