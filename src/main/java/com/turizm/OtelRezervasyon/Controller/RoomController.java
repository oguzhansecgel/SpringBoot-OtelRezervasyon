package com.turizm.OtelRezervasyon.Controller;

import com.turizm.OtelRezervasyon.Core.Dto.Request.Hotel.CreateHotelRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.Hotel.UpdateHotelRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.Room.CreateRoomRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.Room.UpdateRoomRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel.CreateHotelResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel.GetAllHotelResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel.GetByIdHotelResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel.UpdateHotelResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Room.*;
import com.turizm.OtelRezervasyon.Service.Abstracts.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/room")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/getAll")
    public List<GetAllRoomResponse> getAllRoomResponse()
    {
        return roomService.getAllRoom();
    }
    @GetMapping("/getById/{id}")
    public Optional<GetByIdRoomResponse> getByIdRoomResponses(@PathVariable int id)
    {
        return roomService.getByIdRoom(id);
    }
    @GetMapping("/roomsFeatureTrue")
    public List<TrueRoomWithFeaturesResponse> roomsFeatureTrue()
    {
        return roomService.findAllByAllFeaturesTrue();
    }
    @PostMapping("/create")
    public CreateRoomResponse createRoom(@RequestBody CreateRoomRequest room)
    {
        return roomService.createRoom(room);

    }
    @PutMapping("/update/{id}")
    public UpdateRoomResponse updateRoomResponse(@RequestBody UpdateRoomRequest room, @PathVariable int id )
    {
        return roomService.updateRoom(room, id);

    }
    @DeleteMapping("/deleteRoom/{id}")
    public void deletedRoom(@PathVariable int id)
    {
        roomService.deletedRoom(id);
    }
}
