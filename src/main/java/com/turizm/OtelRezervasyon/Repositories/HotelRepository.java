package com.turizm.OtelRezervasyon.Repositories;

import com.turizm.OtelRezervasyon.Core.Dto.Response.Room.GetAllRoomResponse;
import com.turizm.OtelRezervasyon.Entities.Hotel;
import com.turizm.OtelRezervasyon.Entities.HotelFeatures;
import com.turizm.OtelRezervasyon.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {

    @Query("SELECT r FROM Room r JOIN r.hotel h WHERE h.id = :hotelId")
    List<Room> getAllHotelWithRoom(@Param("hotelId") int hotelId);

    @Query("SELECT h FROM HotelFeatures h JOIN h.hotel WHERE h.id= :hotelId")
    List<HotelFeatures> getAllHotelFeatures(@Param("hotelId")int hotelId);
}
