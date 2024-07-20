package com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel;

import com.turizm.OtelRezervasyon.Core.Dto.Response.Room.GetAllRoomResponse;
import com.turizm.OtelRezervasyon.Entities.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelWithRoomResponse {
    private int hotelId;
    private List<GetAllRoomResponse> rooms;
}
