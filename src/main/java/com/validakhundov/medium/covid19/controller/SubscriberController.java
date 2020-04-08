package com.validakhundov.medium.covid19.controller;

import com.validakhundov.medium.covid19.dto.SubscriptionResponseDto;
import com.validakhundov.medium.covid19.service.SubscriberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Valid Akhundov
 */
@RestController
@RequestMapping("api/v1")
public class SubscriberController {

    private SubscriberService subscriberService;
    private Logger logger = LoggerFactory.getLogger(SubscriberController.class);

    public SubscriberController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @PostMapping("subscribe/{email}")
    public SubscriptionResponseDto subscribe(@PathVariable String email) {
        logger.info("requested to subscribe email: {}", email);
        return subscriberService.subscribe(email);
    }

    @PostMapping("unsubscribe/{email}")
    public SubscriptionResponseDto unsubscribe(@PathVariable String email) {
        logger.info("requested to unsubscribe email: {}", email);
        return subscriberService.unsubscribe(email);
    }
}
