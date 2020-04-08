package com.validakhundov.medium.covid19.dto;

import lombok.Data;

/**
 * @author Valid Akhundov
 */
@Data
public class RapidApiCovid19StatDto {
    private String city;
    private String province;
    private String country;
    private String lastUpdate;
    private String keyId;
    private Integer confirmed;
    private Integer deaths;
    private Integer recovered;
}
