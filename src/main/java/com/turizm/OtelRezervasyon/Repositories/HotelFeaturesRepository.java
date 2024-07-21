package com.turizm.OtelRezervasyon.Repositories;

import com.turizm.OtelRezervasyon.Entities.HotelFeatures;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelFeaturesRepository extends JpaRepository<HotelFeatures, Integer> {

    Optional<HotelFeatures> findByHotelId(Integer hotelId);
}
