package com.validakhundov.medium.covid19.service;

import com.validakhundov.medium.covid19.dto.SubscriptionResponseDto;
import com.validakhundov.medium.covid19.entity.Subscriber;

import java.util.List;

/**
 * @author Valid Akhundov
 */
public interface SubscriberService {

    SubscriptionResponseDto subscribe(String email);

    SubscriptionResponseDto unsubscribe(String email);

    List<Subscriber> getSubscribers();
}
