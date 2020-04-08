package com.validakhundov.medium.covid19.repository;


import com.validakhundov.medium.covid19.entity.Statistic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Valid Akhundov
 */
@Repository
public interface StatisticRepository extends CrudRepository<Statistic, String> {

    Optional<Statistic> findTop1ByOrderByLastUpdateDesc();
}
