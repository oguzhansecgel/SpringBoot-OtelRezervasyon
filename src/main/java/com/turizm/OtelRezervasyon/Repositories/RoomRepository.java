package com.turizm.OtelRezervasyon.Repositories;

import com.turizm.OtelRezervasyon.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Integer> {
}
