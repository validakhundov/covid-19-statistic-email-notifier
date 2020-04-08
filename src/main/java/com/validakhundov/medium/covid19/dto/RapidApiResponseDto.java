package com.validakhundov.medium.covid19.dto;


import lombok.Data;

/**
 * @author Valid Akhundov
 */
@Data
public class RapidApiResponseDto {
    private Boolean error;
    private Integer statusCode;
    private String message;
    private RapidApiDataDto data;
}




