package com.validakhundov.medium.covid19.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Valid Akhundov
 */
@Data
public class RapidApiDataDto {
    private String lastChecked;
    private List<RapidApiCovid19StatDto> covid19Stats;
}
