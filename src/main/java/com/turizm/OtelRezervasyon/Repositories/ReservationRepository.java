package com.turizm.OtelRezervasyon.Repositories;

import com.turizm.OtelRezervasyon.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
