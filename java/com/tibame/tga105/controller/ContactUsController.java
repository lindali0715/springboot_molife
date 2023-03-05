package com.tibame.tga105.controller;

import com.tibame.tga105.model.entity.ContactUs;
import com.tibame.tga105.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class ContactUsController {
    @Autowired
    private ContactUsService contactUsService;

    //後台留言管理首頁(讀取資料庫資料)
    @GetMapping("/24admin.chatroom.html")
    public String getAll(Model model){
        List<ContactUs> contactUsList = contactUsService.readMsg();
        model.addAttribute("contactUsList", contactUsList);
        return "24admin.chatroom";
    }

    @GetMapping("/24admin.reply_chatroom.html")
    public String getMsgById(Integer msgId,Model model) throws ChangeSetPersister.NotFoundException {
        ContactUs contactUs = contactUsService.readById(msgId);
        if(contactUs != null){
            model.addAttribute("contactUs",contactUs);
            return "24admin.reply_chatroom";
        }else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    //前台聯絡我們頁面(新增表單)
    @PostMapping("/contactUs")
    public String addMsg(ContactUs contactUs){
        ContactUs contactUs1 = new ContactUs();
        contactUs1.setName(contactUs.getName());
        contactUs1.setEmail(contactUs.getEmail());
        contactUs1.setChatTitle(contactUs.getChatTitle());
        contactUs1.setChatContent(contactUs.getChatContent());
        contactUs1.setCreateTime(new Date());
        contactUs1.setReplyStatus(0);
        contactUsService.createMsg(contactUs1);
        return "24contact";
    }

    //後台回覆留言表單
    @PostMapping("/replyMsg")
    public String updateMsg(ContactUs contactUs){
        contactUsService.updateById(contactUs.getMsgId(),contactUs);
        return "redirect:/24admin.chatroom.html";
    }

    //後台刪除已回覆留言
    @RequestMapping("/deleteMsg/{msgId}")
    public String deleteMsg(@PathVariable Integer msgId){
        contactUsService.deleteById(msgId);
        return "redirect:/24admin.chatroom.html";
    }

}
