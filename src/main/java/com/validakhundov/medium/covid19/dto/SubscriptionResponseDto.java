package com.validakhundov.medium.covid19.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Valid Akhundov
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscriptionResponseDto {
    private Integer code;
    private String message;
}
