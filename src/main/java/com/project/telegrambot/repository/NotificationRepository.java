package com.project.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.telegrambot.model.NotificationTask;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<NotificationTask, Long> {

    public List<NotificationTask> findAllByNotificationDateTime(LocalDateTime localDateTime);

}
