package com.tibame.tga105.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name = "post_info")
@Getter @Setter @ToString
public class PostInfo {
    @Id
    @Column(name = "info_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer infoId;
    @Column(name = "member_id")
    private Integer memberId;
    @Column(name = "admin_id")
    private Integer adminId;
    @Column(name = "info_type")
    private Integer infoType;
    @Column(name = "info_title")
    private String infoTitle;
    @Column(name = "content")
    private String content;
    @Column(name = "info_date")
    @LastModifiedDate
    private Date infoDate;
    @Column(name = "info_status")
    private Integer infoStatus;
}
