package com.tibame.tga105.service.impl;

import com.tibame.tga105.model.dao.ForumReportRepository;
import com.tibame.tga105.model.entity.ForumReport;
import com.tibame.tga105.service.ForumReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ForumReportServiceImpl implements ForumReportService {
    @Autowired
    private ForumReportRepository forumReportRepository;
    @Override
    public ForumReport createReport(ForumReport forumReport) {
        return forumReportRepository.save(forumReport);
    }

    @Override
    public List<ForumReport> readReport() {
        return forumReportRepository.findAll();
    }

    @Override
    public ForumReport readById(Integer forumArticleReportNo) {
        return forumReportRepository.getByReportId(forumArticleReportNo);
    }

    @Override
    public void deleteById(Integer forumArticleReportNo) {
        forumReportRepository.deleteById(forumArticleReportNo);
    }

    @Override
    public ForumReport updateById(Integer forumArticleReportNo, ForumReport forumReport) {
        ForumReport forumReport1 = forumReportRepository.findById(forumArticleReportNo).get();
        if(forumReport1 != null){
            forumReport1.setAdminId(forumReport.getAdminId());
            forumReport1.setForumArticleNo(forumReport.getForumArticleNo());
            forumReport1.setMemberId(forumReport.getMemberId());
            forumReport1.setForumArticleReportReasonNo(forumReport.getForumArticleReportReasonNo());
            forumReport1.setForumArticleReportTime(new Date());
            forumReport1.setForumArticleReportState(forumReport.getForumArticleReportState());
            forumReport1.setForumArticleState(forumReport.getForumArticleState());
        }
        return forumReportRepository.save(forumReport1);
    }
}
