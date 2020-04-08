package com.validakhundov.medium.covid19.scheduler;

import com.validakhundov.medium.covid19.service.NotifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Valid Akhundov
 */
@Component
public class EmailNotifyScheduler {


    private NotifyService notifyService;

    private Logger logger = LoggerFactory.getLogger(EmailNotifyScheduler.class);

    public EmailNotifyScheduler(NotifyService notifyService) {
        this.notifyService = notifyService;
    }


    @Scheduled(initialDelay = 5000, fixedRate = 5 * 60 * 1000)
    public void sendEmails() {
        logger.info("Scheduled to send emails...");
        notifyService.sendEmails();
    }
}
