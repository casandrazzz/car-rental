package com.spring.rental.mapper;

import com.spring.rental.domain.Car;
import com.spring.rental.dto.CarDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarDto toDto(Car car);
}
