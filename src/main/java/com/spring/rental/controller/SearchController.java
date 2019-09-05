package com.spring.rental.controller;

import com.google.common.base.Joiner;
import com.spring.rental.dao.CarRepository;
import com.spring.rental.dto.CarReservationDto;
import com.spring.rental.searchOperations.*;
import com.spring.rental.service.CarSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class SearchController {

    @Autowired
    private CarSearchService carSearchService;

    @Autowired
    private CarRepository carRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/carss")
    @ResponseBody
    public List<CarReservationDto> findAll(@RequestParam(value = "search", required = false) String search) {
        List<SearchCriteriaForCar> params = new ArrayList<>();
        if (search != null) {
            Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
            Matcher matcher = pattern.matcher(search + ",");
            while (matcher.find()) {
                params.add(new SearchCriteriaForCar(matcher.group(1),
                        matcher.group(2), matcher.group(3)));
            }
        }
        return carSearchService.searchCar(params);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/cars/spec")
    @ResponseBody
    public List<CarReservationDto> findAllBySpecification(@RequestParam(value = "search") String search) {
        CarSpecificationBuilder builder = new CarSpecificationBuilder();
        String operationSetExper = Joiner.on("|")
                .join(SearchOperation.SIMPLE_OPERATION_SET);
        Pattern pattern = Pattern.compile("(\\w+?)(" + operationSetExper + ")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(4), matcher.group(3), matcher.group(5));
        }

        Specification<CarReservationDto> spec = builder.build();
        return carRepository.findAll(spec);
    }

    @GetMapping(value = "/cars/spec/or")
    @ResponseBody
    public List<CarReservationDto> findAllByOrPredicate(@RequestParam(value = "search") String search) {
        Specification<CarReservationDto> spec = resolveSpecification(search);
        return carRepository.findAll(spec);
    }

    @GetMapping(value = "/cars/spec/adv")
    @ResponseBody
    public List<CarReservationDto> findAllByAdvPredicate(@RequestParam(value = "search") String search) {
        Specification<CarReservationDto> spec = resolveSpecificationFromInfixExpr(search);
        return carRepository.findAll(spec);
    }

    protected Specification<CarReservationDto> resolveSpecificationFromInfixExpr(String searchParameters) {
        CriteriaParser parser = new CriteriaParser();
        GenericSpecificationsBuilder<CarReservationDto> specBuilder = new GenericSpecificationsBuilder<>();
        return specBuilder.build(parser.parse(searchParameters), CarSpecification::new);
    }

    protected Specification<CarReservationDto> resolveSpecification(String searchParameters) {

        CarSpecificationBuilder builder = new CarSpecificationBuilder();
        String operationSetExper = Joiner.on("|")
                .join(SearchOperation.SIMPLE_OPERATION_SET);
        Pattern pattern = Pattern.compile("(\\p{Punct}?)(\\w+?)(" + operationSetExper + ")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),");
        Matcher matcher = pattern.matcher(searchParameters + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(5), matcher.group(4), matcher.group(6));
        }
        return builder.build();
    }

}
