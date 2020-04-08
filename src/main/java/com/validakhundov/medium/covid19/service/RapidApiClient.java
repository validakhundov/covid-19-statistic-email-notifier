package com.validakhundov.medium.covid19.service;


import com.validakhundov.medium.covid19.dto.RapidApiResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;


/**
 * @author Valid Akhundov
 */
@FeignClient(name = "RapidApiClient", url = "${rapidapi.url}")
public interface RapidApiClient {

    @GetMapping("?country=Azerbaijan")
    RapidApiResponseDto getStatistics(@RequestHeader("x-rapidapi-key") String key);


}
