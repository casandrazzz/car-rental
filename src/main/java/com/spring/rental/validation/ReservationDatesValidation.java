package com.spring.rental.validation;

import com.spring.rental.dto.ReservationDto;
import com.spring.rental.exceptionsCarReservation.*;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.*;

import static com.spring.rental.exceptionsCarReservation.CodesCarReservation.*;

public class ReservationDatesValidation {

    /**
     * validates pick up date and return date
     * @param reservationDto            reservation DTO
     * @throws ReservationDatesException            exception
     * @throws PickUpDateInThePastException         exception
     * @throws ReturnDateInThePastException         exception
     * @throws ReturnDateBeforePickUpDateException          exception
     * @throws ReturnDateTooFarInTheFutureException         exception
     */

    public static void validateReservationDates(ReservationDto reservationDto) throws ReservationDatesException, PickUpDateInThePastException, ReturnDateInThePastException, ReturnDateBeforePickUpDateException, ReturnDateTooFarInTheFutureException {
        LocalDate currentDate = LocalDate.of(2019,8,1);
        LocalDate maximumReturnDate = LocalDate.of(2019, 12, 31);
        List<String> errors = new LinkedList<String>();
        if (StringUtils.isEmpty(reservationDto.getPickUpDate())) {
            errors.add("Pick-up date is empty. Please select a pick-up date");
        } else {
            if (reservationDto.getPickUpDate().isBefore(currentDate)) {
                throw new PickUpDateInThePastException("Pick-up date is in the past", PICK_UP_DATE_IN_THE_PAST);
            }

            if (StringUtils.isEmpty(reservationDto.getReturnDate())) {
                errors.add("Return date is empty.Please select a return date");
            } else {
                if (reservationDto.getReturnDate().isBefore(currentDate)) {
                    throw new ReturnDateInThePastException("Return date is in the past", RETURN_DATE_IN_THE_PAST);
                }
            }

            if (reservationDto.getReturnDate().isBefore(reservationDto.getPickUpDate())) {
                throw new ReturnDateBeforePickUpDateException("Return date is before pick-up date. Please select another date", RETURN_DATE_BEFORE_PICK_UP_DATE);

            }

            if (reservationDto.getReturnDate().isAfter(maximumReturnDate)) {
                throw new ReturnDateTooFarInTheFutureException("Please select a date before 31st of December 2019", RETURN_DATE_TOO_FAR_IN_THE_FUTURE);
            }

            if (!errors.isEmpty()) {
                throw new ReservationDatesException(errors.toArray(new String[]{}));
            }

        }
    }
}
