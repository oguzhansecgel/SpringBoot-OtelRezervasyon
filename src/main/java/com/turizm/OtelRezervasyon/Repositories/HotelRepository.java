package com.turizm.OtelRezervasyon.Repositories;

import com.turizm.OtelRezervasyon.Entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {
}
