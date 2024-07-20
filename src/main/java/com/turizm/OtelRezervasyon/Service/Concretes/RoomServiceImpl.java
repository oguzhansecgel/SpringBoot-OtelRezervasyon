package com.turizm.OtelRezervasyon.Service.Concretes;

import com.turizm.OtelRezervasyon.Core.Dto.Request.Room.CreateRoomRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.Room.UpdateRoomRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Room.*;
import com.turizm.OtelRezervasyon.Core.Mapper.HotelMapper;
import com.turizm.OtelRezervasyon.Core.Mapper.RoomMapper;
import com.turizm.OtelRezervasyon.Entities.Hotel;
import com.turizm.OtelRezervasyon.Entities.Room;
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
    public CreateRoomResponse createRoom(CreateRoomRequest createRoomRequest) {
        Room room = RoomMapper.INSTANCE.createRoomMapper(createRoomRequest);
        Room savedRoom = roomRepository.save(room);
        return new CreateRoomResponse(savedRoom.getId(),savedRoom.getBedCount(),savedRoom.getSquareMeters(),savedRoom.isHasTelevision(),savedRoom.isHasMinibar(),savedRoom.isHasGameConsole(),savedRoom.isHasSafe(),savedRoom.isHasProjector(),savedRoom.getPrice(),savedRoom.getHotel().getId());
    }

    @Override
    public UpdateRoomResponse updateRoom(UpdateRoomRequest updateRoomRequest, Integer id) {
        Optional<Room> roomOptional = roomRepository.findById(id);
        Room existingRoom = roomOptional.get();
        Room room = RoomMapper.INSTANCE.updateRoomMapper(updateRoomRequest,existingRoom);
        Room savedRoom = roomRepository.save(room);
        return new UpdateRoomResponse(savedRoom.getId(),savedRoom.getBedCount(),savedRoom.getSquareMeters(),savedRoom.isHasTelevision(),savedRoom.isHasMinibar(),savedRoom.isHasGameConsole(),savedRoom.isHasSafe(),savedRoom.isHasProjector(),savedRoom.getPrice(),savedRoom.getHotel().getId());
    }

    @Override
    public Optional<GetByIdRoomResponse> getByIdRoom(Integer id) {
        Optional<Room> roomOptional = roomRepository.findById(id);

        return roomOptional.map(RoomMapper.INSTANCE::getByIdRoomMapper);
    }

    @Override
    public List<GetAllRoomResponse> getAllRoom() {
        List<Room> rooms = roomRepository.findAll();
        return RoomMapper.INSTANCE.roomToListRoomResponse(rooms);
    }

    @Override
    public void deletedRoom(Integer id) {
        roomRepository.deleteById(id);
    }

    @Override
    public List<TrueRoomWithFeaturesResponse> findAllByAllFeaturesTrue() {
        List<Room> rooms = roomRepository.findAllByAllFeaturesTrue();
        return RoomMapper.INSTANCE.roomToListRoomTrueFeaturesResponse(rooms);
    }
}
