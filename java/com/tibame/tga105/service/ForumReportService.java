package com.tibame.tga105.service;


import com.tibame.tga105.model.entity.ForumReport;

import java.util.List;

public interface ForumReportService {
    ForumReport createReport(ForumReport forumReport);
    List<ForumReport> readReport();
    ForumReport readById(Integer forumArticleReportNo);
    void deleteById(Integer forumArticleReportNo);
    ForumReport updateById(Integer forumArticleReportNo, ForumReport forumReport);
}
