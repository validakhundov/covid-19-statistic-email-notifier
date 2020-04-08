package com.validakhundov.medium.covid19.service.impl;


import com.validakhundov.medium.covid19.dto.EmailDto;
import com.validakhundov.medium.covid19.dto.RapidApiResponseDto;
import com.validakhundov.medium.covid19.entity.Statistic;
import com.validakhundov.medium.covid19.repository.StatisticRepository;
import com.validakhundov.medium.covid19.service.NotifyService;
import com.validakhundov.medium.covid19.service.EmailService;
import com.validakhundov.medium.covid19.service.RapidApiClient;
import com.validakhundov.medium.covid19.service.SubscriberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.validakhundov.medium.covid19.util.Helper.buildEmailDto;
import static com.validakhundov.medium.covid19.util.Helper.buildStatistic;

/**
 * @author Valid Akhundov
 */
@Service
public class NotifyServiceImpl implements NotifyService {

    private SubscriberService subscriberService;
    private EmailService emailService;
    private RapidApiClient rapidApiClient;
    private StatisticRepository statisticRepository;

    @Value("${rapidapi.key}")
    private String rapidApiKey;

    private Logger logger = LoggerFactory.getLogger(NotifyServiceImpl.class);

    public NotifyServiceImpl(SubscriberService subscriberService,
                             EmailService emailService,
                             RapidApiClient rapidApiClient,
                             StatisticRepository statisticRepository) {
        this.subscriberService = subscriberService;
        this.emailService = emailService;
        this.rapidApiClient = rapidApiClient;
        this.statisticRepository = statisticRepository;
    }

    @Override
    public void sendEmails() {
        RapidApiResponseDto rapidApiResponseDto = rapidApiClient.getStatistics(rapidApiKey);
        logger.info("Rapid Api Response: {}", rapidApiResponseDto);
        if (!rapidApiResponseDto.getError()) {
            Statistic statistic = statisticRepository.findTop1ByOrderByLastUpdateDesc().orElse(null);
            if (statistic == null || !statistic.getLastUpdate().equals(rapidApiResponseDto.getData().getLastChecked())) {
                Statistic newStatistic = buildStatistic(rapidApiResponseDto);
                newStatistic.setNewCount(statistic != null ? (newStatistic.getTotal() - statistic.getTotal()) : 0);
                statisticRepository.save(newStatistic);
                EmailDto emailDto = buildEmailDto(newStatistic);
                logger.info("EmailDto builded: {}", emailDto);
                subscriberService.getSubscribers().forEach(s -> {
                    logger.info("daily constellation info sending to: {}", s.getEmail());
                    emailDto.setTo(s.getEmail());
                    emailService.send(emailDto);
                });
            } else {
                logger.info("New statistic not found, last checked: {}", rapidApiResponseDto.getData().getLastChecked());
            }
        }

    }
}
