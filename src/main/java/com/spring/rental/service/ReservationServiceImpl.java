package com.spring.rental.service;

import com.spring.rental.dao.CarRepository;
import com.spring.rental.dao.CustomerRepository;
import com.spring.rental.dao.ReservationRepository;
import com.spring.rental.domain.Car;
import com.spring.rental.domain.Customer;
import com.spring.rental.domain.Reservation;
import com.spring.rental.dto.CarReservationDto;
import com.spring.rental.dto.ReservationDto;
import com.spring.rental.exceptionsCarReservation.*;
import com.spring.rental.transformer.ReservationDtoToReservationTransformer;
import com.spring.rental.validation.ReservationDatesValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

import static com.spring.rental.exceptionsCarReservation.CodesCarReservation.NO_AVAILABLE_CAR_FOUND;
import static java.time.temporal.ChronoUnit.DAYS;


@Service
public class ReservationServiceImpl implements ReservationService {

    /** implements ReservationService
     * CRUD operations for reservation object
     * additional methods for calculation the total cost of renting a car, applying discount
     */

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CustomerRepository customerRepository;

    private CarReservationDto carReservationDto;
    private ReservationDto reservationDto;


    @Override
    public long calculateReservationCost(String vehicleType) {


        Reservation reservation = ReservationDtoToReservationTransformer.transform(reservationDto);


        long reservationPriceForConvertible = 20;
        long reservationPriceForCoupe = 20;
        long reservationPriceForLimousine = 25;
        long reservationPriceForPickUP = 30;
        long reservationPriceForSUV = 30;
        long reservationPriceForVan = 35;
        long rentalPeriod = DAYS.between(reservation.pickUpDate, reservation.returnDate);


        switch (carReservationDto.getVehicleType()) {
            case "Convertible":
                return reservationPriceForConvertible * rentalPeriod;
            case "Coupe":
                return reservationPriceForCoupe * rentalPeriod;
            case "Limousine":
                return reservationPriceForLimousine * rentalPeriod;
            case"Pick-up":
                return reservationPriceForPickUP*rentalPeriod;
            case"SUV"    :
                return reservationPriceForSUV * rentalPeriod;
            case "Van" :
                return reservationPriceForVan * rentalPeriod;

        }
     return calculateReservationCost(vehicleType);

    }


    @Override
    public void addReservation(ReservationDto reservationDto) {



        Reservation reservation = ReservationDtoToReservationTransformer.transform(reservationDto);


        Car car = carRepository.findById(reservationDto.getPkC());


        Customer customer = customerRepository.findById(reservationDto.getPkCostumer());



        reservation.setCar(car);
        reservation.setCustomer(customer);

        if(reservation.getLocation() !=null){
            reservation.setRented(true);
        };

        reservationRepository.saveAndFlush(reservation);

   }

    @Override
    public void deleteReservation(long pk) {

    }

    @Override
    public void updateReservation() {

    }

    @Override
    public List<ReservationDto> getReservationsByCustomer(String emailAddres, String firstName, String lastName) {

        List<ReservationDto> reservationsByCustomer = new ArrayList<>();

        List<Long> reservations = reservationRepository.getReservationsByCustomer(emailAddres, firstName, lastName);

        List<Reservation> reservationList = new ArrayList<>();
        for (Long reservation : reservations){
            Reservation reservationId = reservationRepository.findById(reservation).get();
            reservationList.add(reservationId);
        }


        for (Reservation reservation : reservationList) {

            ReservationDto reservationDto = new ReservationDto();
            reservationDto.setLocation(reservation.getLocation());
            reservationDto.setPickUpDate(reservation.getPickUpDate());
            reservationDto.setReturnDate(reservation.getReturnDate());
            reservationDto.setPkC(reservation.getCar().getPkC());
            reservationDto.setPkCostumer(reservation.getCustomer().getPk());


            reservationsByCustomer.add(reservationDto);
            if (reservationsByCustomer.isEmpty()) {
                try {
                    throw new NoAvailableCarFound("Sorry, no available cars were found.", NO_AVAILABLE_CAR_FOUND);
                } catch (NoAvailableCarFound noAvailableCarFound) {
                    noAvailableCarFound.printStackTrace();
                }
            }


        }
        return reservationsByCustomer;

    }


}

