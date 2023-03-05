package com.tibame.tga105.model.dao;

import com.tibame.tga105.model.entity.ForumReportReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumReportReasonRepository extends JpaRepository<ForumReportReason,Integer> {
}
