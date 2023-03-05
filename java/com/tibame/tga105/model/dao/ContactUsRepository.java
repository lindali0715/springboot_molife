package com.tibame.tga105.model.dao;

import com.tibame.tga105.model.entity.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactUsRepository extends JpaRepository<ContactUs, Integer> {
    List<ContactUs> findAll();

    void deleteById(Integer msgId);

    @Override
    Optional<ContactUs> findById(Integer msgId);

    @Query(value = "select * from contact_us where msg_id = ?", nativeQuery = true)
    ContactUs getByMsgId(Integer msgId);


}
