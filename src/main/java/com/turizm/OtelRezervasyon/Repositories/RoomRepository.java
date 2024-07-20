package com.turizm.OtelRezervasyon.Repositories;

import com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel.GetAllHotelResponse;
import com.turizm.OtelRezervasyon.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Integer> {

    @Query("SELECT r FROM Room r WHERE r.hasTelevision = true OR r.hasMinibar = true OR r.hasGameConsole = true OR r.hasSafe = true OR r.hasProjector = true")
    List<Room> findAllByAllFeaturesTrue();
}
