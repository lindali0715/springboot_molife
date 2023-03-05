package com.tibame.tga105.controller;

import com.tibame.tga105.model.entity.ForumReport;
import com.tibame.tga105.service.ForumReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/forumReport")
public class ForumReportController {
    @Autowired
    private ForumReportService forumReportService;

    @GetMapping
    public List<ForumReport> getAll(){
        return forumReportService.readReport();
    }

    @GetMapping("/{forumArticleReportNo}")
    public ForumReport getById(@PathVariable Integer forumArticleReportNo){
        return forumReportService.readById(forumArticleReportNo);
    }

    @PostMapping
    public ForumReport addReport(){
        ForumReport forumReport = new ForumReport();
        forumReport.setAdminId(1);
        forumReport.setForumArticleNo(1);
        forumReport.setMemberId(1);
        forumReport.setForumArticleReportReasonNo(1);
        forumReport.setForumArticleReportTime(new Date());
        forumReport.setForumArticleReportState(0);
        forumReport.setForumArticleState(0);
        return forumReportService.createReport(forumReport);
    }

    @PutMapping("/{forumArticleReportNo}")
    public ForumReport updateReport(@PathVariable Integer forumArticleReportNo, @RequestBody ForumReport forumReport){
        return forumReportService.updateById(forumArticleReportNo,forumReport);
    }

    @DeleteMapping("/{forumArticleReportNo}")
    public void deleteReport(@PathVariable Integer forumArticleReportNo){
        forumReportService.deleteById(forumArticleReportNo);
    }
}
