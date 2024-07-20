package com.turizm.OtelRezervasyon.Service.Abstracts;



import com.turizm.OtelRezervasyon.Core.Dto.Request.Room.CreateRoomRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.Room.UpdateRoomRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Room.*;
import com.turizm.OtelRezervasyon.Entities.Room;

import java.util.List;
import java.util.Optional;
////
public interface RoomService {
    CreateRoomResponse createRoom(CreateRoomRequest createRoomRequest);
    UpdateRoomResponse updateRoom(UpdateRoomRequest updateRoomRequest, Integer id);
    Optional<GetByIdRoomResponse> getByIdRoom(Integer id);
    List<GetAllRoomResponse> getAllRoom();
    void deletedRoom(Integer id);
    List<TrueRoomWithFeaturesResponse> findAllByAllFeaturesTrue();
}
