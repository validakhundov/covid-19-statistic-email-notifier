package com.validakhundov.medium.covid19.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Valid Akhundov
 */
@Data
@Entity
@Table(name = "statistic")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Statistic {

    @Id
    private String lastUpdate;
    private Integer total;
    private Integer death;
    private Integer recovered;
    private Integer newCount;
    private Integer active;

}
