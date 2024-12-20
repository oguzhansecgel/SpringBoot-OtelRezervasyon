package com.turizm.OtelRezervasyon.Service.Abstracts;

import com.turizm.OtelRezervasyon.Core.Dto.Request.Hotel.CreateHotelRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.Hotel.UpdateHotelRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel.*;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Room.GetAllRoomResponse;
import com.turizm.OtelRezervasyon.Entities.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    CreateHotelResponse createHotel(CreateHotelRequest createHotelRequest);
    UpdateHotelResponse updateHotel(UpdateHotelRequest updateHotelRequest, Integer id);
    Optional<GetByIdHotelResponse> getByIdHotel(Integer id);
    List<GetAllHotelResponse> getAllHotel();
    void deletedHotel(Integer id);

   HotelWithRoomResponse getAllHotelWithRoom(Integer hotelId);
   HotelWithHotelFeaturesResponse getAllHotelWithHotelFeatures(Integer hotelId);


}
