package test.repositoryTest;

import com.spring.rental.dao.ReservationRepository;
import com.spring.rental.domain.Reservation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
public class ReservationRepositoryTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private static ReservationRepository reservationRepository;



    @Test
    void should_findByLocation_thenReturnReservation(){

        Reservation reservation = new Reservation();
        reservation.setLocation("Cluj Napoca");
        entityManager.persist(reservation);
        entityManager.flush();

        Reservation found = reservationRepository.findByLocation(reservation.getLocation());

        assertSame(found.getLocation(), reservation.getLocation());
    }
}
