package com.spring.rental.service;

import com.spring.rental.dao.CarRepository;
import com.spring.rental.dao.CustomerRepository;
import com.spring.rental.dao.ReservationRepository;
import com.spring.rental.domain.Car;
import com.spring.rental.domain.Customer;
import com.spring.rental.domain.Reservation;
import com.spring.rental.dto.CarReservationDto;
import com.spring.rental.dto.ReservationDto;
import com.spring.rental.enums.VehicleType;
import com.spring.rental.exceptionsCarReservation.*;
import com.spring.rental.transformer.ReservationDtoToReservationTransformer;
import com.spring.rental.validation.ReservationDatesValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.spring.rental.enums.VehicleType.CONVERTIBLE;
import static com.spring.rental.exceptionsCarReservation.CodesCarReservation.NO_AVAILABLE_CAR_FOUND;
import static java.lang.Enum.valueOf;
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



    @Override
    public long calculateReservationCost(ReservationDto reservationDto, String vehicleType) throws ReservationDatesException, ReturnDateBeforePickUpDateException, PickUpDateInThePastException, ReturnDateInThePastException, ReturnDateTooFarInTheFutureException {

        ReservationDatesValidation.validateReservationDates(reservationDto);
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
     return calculateReservationCost(reservationDto, vehicleType);

    }


    @Override
    public void addReservation(ReservationDto reservationDto) throws ReservationDatesException,
            ReturnDateBeforePickUpDateException,
            PickUpDateInThePastException,
            ReturnDateInThePastException,
            ReturnDateTooFarInTheFutureException {


        ReservationDatesValidation.validateReservationDates(reservationDto);
        Reservation reservation = ReservationDtoToReservationTransformer.transform(reservationDto);

        Car car = carRepository.findById(reservationDto.getPkCar());
        Customer customer = customerRepository.findById(reservationDto.getPk());



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
    public List<ReservationDto> getReservationsByCustomer(long pk) {

        List<ReservationDto> reservationsByCustomer = new ArrayList<>();

        List<ReservationDto> reservations = reservationRepository.getReservationsByCustomer(pk);

        for (ReservationDto reservation : reservations) {

            ReservationDto reservationDto = new ReservationDto();
            reservationDto.setLocation(reservation.getLocation());
            reservationDto.setPickUpDate(reservation.getPickUpDate());
            reservationDto.setReturnDate(reservation.getReturnDate());
            reservationDto.setPkCar(reservation.getPkCar());
            reservationDto.setPk(reservation.getPk());


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

