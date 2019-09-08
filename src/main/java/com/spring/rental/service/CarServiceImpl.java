package com.spring.rental.service;

import com.spring.rental.dao.CarRepository;
import com.spring.rental.domain.Car;
import com.spring.rental.dto.CarDto;
import com.spring.rental.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Autowired
    public CarServiceImpl(final CarRepository carRepository,
                          final CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    @Override
    public List<CarDto> findAll() {
        return carRepository.findAll().stream().map(carMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void delete(long pk) {
        carRepository.deleteById(pk);
    }

    @Override
    public Long save(CarDto carDto) {
        Car car = new Car();
        if (carDto.getId() != null) {
            // update car if already exists
            car = loadById(carDto.getId());
        }
        return carRepository.save(carMapper.toEntity(carDto, car)).getPkC();
    }

    @Override
    public CarDto findById(Long id) {
        return carMapper.toDto(loadById(id));
    }

    private Car loadById(Long id) {
        return carRepository.findById(id).orElse(null);
    }
}
