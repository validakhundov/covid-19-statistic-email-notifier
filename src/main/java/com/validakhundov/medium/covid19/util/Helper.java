package com.validakhundov.medium.covid19.util;

import com.validakhundov.medium.covid19.dto.EmailDto;
import com.validakhundov.medium.covid19.dto.RapidApiResponseDto;
import com.validakhundov.medium.covid19.entity.Statistic;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Valid Akhundov
 */
public class Helper {

    public static EmailDto buildEmailDto(Statistic statistic) {
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy [HH:mm]");
        String subject = "Covid-19 Azerbaijan statistics " + formater.format(new Date());
        StringBuilder sb = new StringBuilder();
        sb.append("Ümumi yoluxan: ");
        sb.append("<b>");
        sb.append(statistic.getTotal());
        sb.append("</b>");
        sb.append("<br>");
        sb.append("Yeni yoluxan: ");
        sb.append("<b style='color:orange'>");
        sb.append(statistic.getNewCount());
        sb.append("</b>");
        sb.append("<br>");
        sb.append("Sağalan: ");
        sb.append("<b style='color:green'>");
        sb.append(statistic.getRecovered());
        sb.append("</b>");
        sb.append("<br>");
        sb.append("Ölüm halı: ");
        sb.append("<b style='color:red'>");
        sb.append(statistic.getDeath());
        sb.append("</b>");
        sb.append("<br>");
        sb.append("Aktiv xəstə: ");
        sb.append("<b>");
        sb.append(statistic.getActive());
        sb.append("</b>");
        return EmailDto.builder().subject(subject).text(sb.toString()).build();
    }

    public static Statistic buildStatistic(RapidApiResponseDto dto) {
        int total = dto.getData().getCovid19Stats().get(0).getConfirmed();
        int death = dto.getData().getCovid19Stats().get(0).getDeaths();
        int recovered = dto.getData().getCovid19Stats().get(0).getRecovered();
        return Statistic.builder()
                .lastUpdate(dto.getData().getLastChecked())
                .total(total)
                .death(death)
                .recovered(recovered)
                .active(total - (death + recovered))
                .build();
    }

}
