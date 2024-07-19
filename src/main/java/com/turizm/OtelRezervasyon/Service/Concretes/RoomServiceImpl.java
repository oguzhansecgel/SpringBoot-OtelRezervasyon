package com.turizm.OtelRezervasyon.Service.Concretes;

import com.turizm.OtelRezervasyon.Core.Dto.Response.Room.CreateRoomResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Room.GetAllRoomResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Room.GetByIdRoomResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Room.UpdateRoomResponse;
import com.turizm.OtelRezervasyon.Repositories.RoomRepository;
import com.turizm.OtelRezervasyon.Service.Abstracts.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public CreateRoomResponse createRoom(CreateRoomResponse createRoomResponse) {

        return null;
    }

    @Override
    public UpdateRoomResponse updateRoom(UpdateRoomResponse updateRoomResponse, Integer id) {
        return null;
    }

    @Override
    public Optional<GetByIdRoomResponse> getByIdRoom(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<GetAllRoomResponse> getAllRoom() {
        return List.of();
    }

    @Override
    public void deletedRoom(Integer id) {

    }
}
