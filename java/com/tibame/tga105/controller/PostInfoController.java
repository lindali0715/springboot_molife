package com.tibame.tga105.controller;

import com.tibame.tga105.model.entity.PostInfo;
import com.tibame.tga105.service.PostInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostInfoController {

   @Autowired
    private PostInfoService postInfoService;

   //前台通知信頁面(讀取資料庫)
   @GetMapping("/24post_info.html")
    public String getInfo(Model model){
      List<PostInfo> postInfoList = postInfoService.readInfo();
      model.addAttribute("postInfoList", postInfoList);
      return "24post_info";
   }

    //前台通知信讀取頁面(讀取資料庫)
    @GetMapping ("/24post_info.check")
    public String getInfoById(Integer infoId, Model model) throws ChangeSetPersister.NotFoundException {
        PostInfo postInfo = postInfoService.readById(infoId);
        if(postInfo != null){
            model.addAttribute("postInfo",postInfo);
            return "24post_info.check";
        }else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    @RequestMapping("/updateInfo")
    public String updateInfo(PostInfo postInfo){
       postInfoService.updateById(postInfo.getInfoId(), postInfo);
       return "redirect:/24post_info.html";
    }

    //前台刪除已讀通知信
    @RequestMapping("/deleteInfo/{infoId}")
    public String deleteMsg(@PathVariable Integer infoId){
        postInfoService.deleteById(infoId);
        return "redirect:/24post_info.html";
    }

}
