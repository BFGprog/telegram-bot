package com.project.telegrambot.response;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.project.telegrambot.Service.MessageService;
import com.project.telegrambot.model.NotificationTask;
import com.project.telegrambot.repository.NotificationRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class SendNotification {

    private final NotificationRepository notificationRepository;
    private final MessageService messageService;


    public SendNotification(NotificationRepository notificationRepository, MessageService messageService) {
        this.notificationRepository = notificationRepository;
        this.messageService = messageService;
    }


    @Scheduled(fixedRate = 1, timeUnit = TimeUnit.MINUTES)
    public void sendNotification() {

        LocalDateTime timeNow = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        List<NotificationTask> notificationTasks = notificationRepository.findAllByNotificationDateTime(timeNow);

        notificationTasks.stream()
                .forEach(nt -> {
                    Long chatId = nt.getChatId();
                    messageService.answer(chatId, "Hey! " + nt.getText());
                });



    }


}
