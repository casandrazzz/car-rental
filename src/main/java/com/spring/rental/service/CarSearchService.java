package com.spring.rental.service;

import com.spring.rental.dao.CarRepository;
import com.spring.rental.domain.Car;
import com.spring.rental.dto.CarReservationDto;
import com.spring.rental.searchOperations.CarSearchQueryCriteriaConsumer;
import com.spring.rental.searchOperations.SearchCriteriaForCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class CarSearchService {

    /**
     * searches for car according the specified criteria
     */


    @PersistenceContext
    private EntityManager entityManager;

    public List<CarReservationDto> searchCar(final List<SearchCriteriaForCar> params) {
        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<CarReservationDto> query = builder.createQuery(CarReservationDto.class);
        final Root r = query.from(CarReservationDto.class);

        Predicate predicate = builder.conjunction();
        CarSearchQueryCriteriaConsumer searchConsumer = new CarSearchQueryCriteriaConsumer(predicate, builder, r);
        params.stream().forEach(searchConsumer);
        predicate = searchConsumer.getPredicate();
        query.where(predicate);

        return entityManager.createQuery(query).getResultList();
    }


}
