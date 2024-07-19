package com.turizm.OtelRezervasyon.Service.Abstracts;



import com.turizm.OtelRezervasyon.Core.Dto.Response.Room.CreateRoomResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Room.GetAllRoomResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Room.GetByIdRoomResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Room.UpdateRoomResponse;

import java.util.List;
import java.util.Optional;
////
public interface RoomService {
    CreateRoomResponse createRoom(CreateRoomResponse createRoomResponse);
    UpdateRoomResponse updateRoom(UpdateRoomResponse updateRoomResponse, Integer id);
    Optional<GetByIdRoomResponse> getByIdRoom(Integer id);
    List<GetAllRoomResponse> getAllRoom();
    void deletedRoom(Integer id);
}
