package com.validakhundov.medium.covid19.service;

import com.validakhundov.medium.covid19.dto.EmailDto;

/**
 * @author Valid Akhundov
 */
public interface EmailService {
    void send(EmailDto emailDto);
}
