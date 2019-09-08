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
     * @throws ReservationDatesException            exception
     * @throws PickUpDateInThePastException         exception
     * @throws ReturnDateInThePastException         exception
     * @throws ReturnDateBeforePickUpDateException          exception
     * @throws ReturnDateTooFarInTheFutureException         exception
     */

    public static void validateReservationDates(LocalDate pickUpDate, LocalDate returnDate) throws ReservationDatesException, PickUpDateInThePastException, ReturnDateInThePastException, ReturnDateBeforePickUpDateException, ReturnDateTooFarInTheFutureException {
        LocalDate currentDate = LocalDate.of(2019,8,1);
        LocalDate maximumReturnDate = LocalDate.of(2019, 12, 31);
        List<String> errors = new LinkedList<String>();
        if (StringUtils.isEmpty(pickUpDate)) {
            errors.add("Pick-up date is empty. Please select a pick-up date");
        } else {
            if (pickUpDate.isBefore(currentDate)) {
                throw new PickUpDateInThePastException("Pick-up date is in the past", PICK_UP_DATE_IN_THE_PAST);
            }

            if (StringUtils.isEmpty(returnDate)) {
                errors.add("Return date is empty.Please select a return date");
            } else {
                if (returnDate.isBefore(currentDate)) {
                    throw new ReturnDateInThePastException("Return date is in the past", RETURN_DATE_IN_THE_PAST);
                }
            }

            if (returnDate.isBefore(pickUpDate)) {
                throw new ReturnDateBeforePickUpDateException("Return date is before pick-up date. Please select another date", RETURN_DATE_BEFORE_PICK_UP_DATE);

            }

            if (maximumReturnDate.isAfter(maximumReturnDate)) {
                throw new ReturnDateTooFarInTheFutureException("Please select a date before 31st of December 2019", RETURN_DATE_TOO_FAR_IN_THE_FUTURE);
            }

            if (!errors.isEmpty()) {
                throw new ReservationDatesException(errors.toArray(new String[]{}));
            }

        }
    }
}
