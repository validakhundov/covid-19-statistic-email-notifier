package com.validakhundov.medium.covid19.service.impl;

import com.validakhundov.medium.covid19.dto.SubscriptionResponseDto;
import com.validakhundov.medium.covid19.entity.Subscriber;
import com.validakhundov.medium.covid19.repository.SubscriberRepository;
import com.validakhundov.medium.covid19.service.SubscriberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Valid Akhundov
 */
@Service
public class SubscriberServiceImpl implements SubscriberService {

    private SubscriberRepository subscriberRepository;
    private Logger logger = LoggerFactory.getLogger(SubscriberServiceImpl.class);

    public SubscriberServiceImpl(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    @Override
    public SubscriptionResponseDto subscribe(String email) {
        subscriberRepository.save(Subscriber.builder().email(email).status("subscribed").build());
        logger.info("email subscribed successfully: {}", email);
        return SubscriptionResponseDto.builder().code(0).message("Subscribed successfully!").build();
    }

    @Override
    public SubscriptionResponseDto unsubscribe(String email) {
        subscriberRepository.save(Subscriber.builder().email(email).status("unsubscribed").build());
        logger.info("email unsubscribed successfully: {}", email);
        return SubscriptionResponseDto.builder().code(0).message("Unsubscribed successfully!").build();
    }

    @Override
    public List<Subscriber> getSubscribers() {
        logger.info("getting subscribed emails...");
        return subscriberRepository.findAllByStatus("subscribed");
    }
}
