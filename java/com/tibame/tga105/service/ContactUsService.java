package com.tibame.tga105.service;

import com.tibame.tga105.model.entity.ContactUs;

import java.util.List;

public interface ContactUsService {
    ContactUs createMsg(ContactUs contactUs);
    List<ContactUs> readMsg();
    ContactUs readById(Integer msgId);
    void deleteById(Integer msgId);
    ContactUs updateById(Integer msgId, ContactUs contactUs);
}
