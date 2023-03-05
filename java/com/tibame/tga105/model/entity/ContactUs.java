package com.tibame.tga105.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name = "contact_us")
@Getter @Setter @ToString
public class ContactUs {
    @Id
    @Column(name = "msg_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer msgId;
    @Column(name = "member_id")
    private Integer memberId;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "chat_title")
    private String chatTitle;
    @Column(name = "chat_content")
    private String chatContent;
    @Column(name = "reply_status")
    private Integer replyStatus;
    @Column(name = "createtime")
    @LastModifiedDate
    private Date createTime;
    @Column(name = "response")
    private String response;
}
