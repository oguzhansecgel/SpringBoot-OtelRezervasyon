package com.turizm.OtelRezervasyon.Core.Mapper;

import com.turizm.OtelRezervasyon.Core.Dto.Request.Room.CreateRoomRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.Room.UpdateRoomRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Room.GetAllRoomResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Room.GetByIdRoomResponse;
import com.turizm.OtelRezervasyon.Entities.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    @Mapping(target = "id", source = "id")
    Room toRoom(Integer id);


    @Mapping(target = "hotel.id",source = "hotelId")
    Room createRoomMapper(CreateRoomRequest createRoomRequest);

    @Mapping(target = "hotel.id",source = "hotelId")
    Room updateRoomMapper(UpdateRoomRequest updateRoomRequest,@MappingTarget Room room);

    GetByIdRoomResponse getByIdRoomMapper(Room room);

    GetAllRoomResponse getAllRoomMapper(Room room);
    List<GetAllRoomResponse> roomToListRoomResponse(List<Room> rooms);

}
