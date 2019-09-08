package com.spring.rental.mapper;

import com.spring.rental.domain.Car;
import com.spring.rental.dto.CarDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(target = "id", source = "pkC")
    CarDto toDto(Car car);

    @Mapping(target = "pkC", source = "id")
    Car toEntity(CarDto carDto, @MappingTarget Car car);
}
