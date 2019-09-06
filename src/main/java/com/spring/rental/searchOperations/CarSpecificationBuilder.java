package com.spring.rental.searchOperations;

import com.spring.rental.domain.Car;
import com.spring.rental.dto.CarReservationDto;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@Data

public class CarSpecificationBuilder {

    /**
     * builder for car specifications
     */

    private final List<SpecSearchCriteria> params;

    public CarSpecificationBuilder() {
        params = new ArrayList<>();
    }

    // API

    public final CarSpecificationBuilder with(final String key, final String operation, final Object value, final String prefix, final String suffix) {
        return with(null, key, operation, value, prefix, suffix);
    }

    public final CarSpecificationBuilder with(final String orPredicate, final String key, final String operation, final Object value, final String prefix, final String suffix) {
        SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
        if (op != null) {
            op = SpecSearchCriteria.getSearchOperation(prefix, suffix, op);
            params.add(new SpecSearchCriteria(orPredicate, key, op, value));
        }
        return this;
    }

    public Specification<CarReservationDto> build() {
        if (params.size() == 0)
            return null;

        Specification<CarReservationDto> result = new CarSpecification(params.get(0));

        for (int i = 1; i < params.size(); i++) {
            result = params.get(i).isOrPredicate()
                    ? Specification.where(result).or(new CarSpecification(params.get(i)))
                    : Specification.where(result).and(new CarSpecification(params.get(i)));
        }

        return result;
    }

    public final CarSpecificationBuilder with(CarSpecification spec) {
        params.add(spec.getCriteria());
        return this;
    }

    public final CarSpecificationBuilder with(SpecSearchCriteria criteria) {
        params.add(criteria);
        return this;
    }


    }

