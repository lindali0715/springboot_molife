package com.tibame.tga105.controller;

import com.tibame.tga105.model.entity.ForumReport;
import com.tibame.tga105.service.ForumReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class ForumReportController {
    
    @Autowired
    private ForumReportService forumReportService;

    @Autowired
    private PostInfoService postInfoService;

    //後台論壇管理讀取檢舉文章(讀資料庫)
    @GetMapping("/24admin.forum.html")
    public String getReport(Model model){
        List<ForumReport> forumReportList = forumReportService.readReport();
        model.addAttribute("forumReportList", forumReportList);
        return "24admin.forum";
    }

    //後台論壇管理審核檢舉
    @GetMapping("/24admin.forum_review.html")
    public String getReportById(Integer forumArticleReportNo, Model model) throws ChangeSetPersister.NotFoundException {
        ForumReport forumReport = forumReportService.readById(forumArticleReportNo);
        if(forumReport != null){
            model.addAttribute("forumReport",forumReport);
            return "24admin.forum_review";
        }else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    //前台新增檢舉
    @RequestMapping("/addReport")
    public String addReport(ForumReport forumReport){
        forumReport = new ForumReport();
        forumReport.setForumArticleNo(6);
        forumReport.setMemberId(6);
        forumReport.setForumTitle("[急問]有沒有人可以幫忙代養2個月，每個月給3萬酬勞");
        forumReport.setForumContent("因為近期需要出差2個月的緣故,我家的瑪爾濟斯沒有人照顧,所以希望可以找個人幫忙! 請留下匯款帳號及電話方便之後聯絡好心人及匯款~拜託了!!!");
        forumReport.setForumArticleReportReasonNo(0);
        forumReport.setForumArticleReportTime(new Date());
        forumReport.setForumArticleReportStatus(0);
        forumReport.setForumArticleStatus(0);
        forumReportService.createReport(forumReport);
        return "24forum.index";
    }

    //後台論壇管理檢舉成立
    @RequestMapping("/acceptReport")
    public String acceptReport(ForumReport forumReport, PostInfo postInfo){
    	forumReport.setForumArticleStatus(1);
        forumReportService.updateById(3, forumReport);
        
        postInfo = new PostInfo();
        postInfo.setMemberId(1);
        postInfo.setAdminId(1);
        postInfo.setInfoTitle("寵物論壇");
        postInfo.setContent("親愛的會員您好!您的文章因違反規定而被檢舉,已下架您的文章!");
        postInfo.setInfoDate(new Date());
        postInfo.setInfoStatus(0);
        postInfo.setInfoType(1);
        postInfoService.createInfo(postInfo);

        return "redirect:/24admin.forum.html";
    }

    //後台論壇管理檢舉不成立
    @RequestMapping("/refuseReport")
    public String refuseReport(ForumReport forumReport){
        forumReport.setForumArticleStatus(0);
        forumReportService.updateById(forumReport.getForumArticleReportNo(), forumReport);
        return "redirect:/24admin.forum.html";
    }

    //後台論壇管理下架已審核之文章 
    @RequestMapping("/deleteReport/{forumArticleReportNo}")
    public String deleteReport(@PathVariable Integer forumArticleReportNo){
        forumReportService.deleteById(forumArticleReportNo);
        return "redirect:/24admin.forum.html";
    }
}
