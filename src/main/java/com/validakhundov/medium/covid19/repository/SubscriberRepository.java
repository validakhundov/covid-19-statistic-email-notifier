package com.validakhundov.medium.covid19.repository;


import com.validakhundov.medium.covid19.entity.Subscriber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author Valid Akhundov
 */
@Repository
public interface SubscriberRepository extends CrudRepository<Subscriber,String> {
    List<Subscriber> findAllByStatus(String status);
}
