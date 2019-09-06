package com.spring.rental.searchOperations;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;
import com.spring.rental.domain.Car;
import com.spring.rental.dto.CarReservationDto;

public class MyCarPredicate {

    /**
     * predicate for car
     */

    private SearchCriteriaForCar criteria;

    public MyCarPredicate(final SearchCriteriaForCar criteria) {
        this.criteria = criteria;
    }

    public BooleanExpression getPredicate() {
        final PathBuilder<CarReservationDto> entityPath = new PathBuilder<CarReservationDto>(CarReservationDto.class, "Car");

        if (isNumeric(criteria.getValue().toString())) {
            final NumberPath<Integer> path = entityPath.getNumber(criteria.getKey(), Integer.class);
            final int value = Integer.parseInt(criteria.getValue().toString());
            switch (criteria.getOperation()) {
                case ":":
                    return path.eq(value);
                case ">":
                    return path.goe(value);
                case "<":
                    return path.loe(value);
            }
        } else {
            final StringPath path = entityPath.getString(criteria.getKey());
            if (criteria.getOperation().equalsIgnoreCase(":")) {
                return path.containsIgnoreCase(criteria.getValue().toString());
            }
        }
        return null;
    }

    public SearchCriteriaForCar getCriteria() {
        return criteria;
    }

    public void setCriteria(final SearchCriteriaForCar criteria) {
        this.criteria = criteria;
    }

    public static boolean isNumeric(final String str) {
        try {
            Integer.parseInt(str);
        } catch (final NumberFormatException e) {
            return false;
        }
        return true;
    }
}