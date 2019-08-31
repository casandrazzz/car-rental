package com.spring.rental.searchOperations;

import com.spring.rental.domain.Car;
import com.spring.rental.dto.CarReservationDto;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Data

public class CarSpecification implements Specification<CarReservationDto> {

    /**
     * search criteria
     */

    private SpecSearchCriteria criteria;

    public CarSpecification(final SpecSearchCriteria criteria){
        super();
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<CarReservationDto> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        switch (criteria.getOperation()) {

            case EQUALITY:
                return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());


            default:
                return null;
        }
    }
}
