package com.turizm.OtelRezervasyon.Core.Mapper;

import com.turizm.OtelRezervasyon.Core.Dto.Request.Hotel.CreateHotelRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.Hotel.UpdateHotelRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel.GetAllHotelResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel.GetByIdHotelResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel.HotelWithHotelFeaturesResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel.HotelWithRoomResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.HotelFeatures.GetAllHotelFeaturesResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Room.GetAllRoomResponse;
import com.turizm.OtelRezervasyon.Entities.Hotel;
import com.turizm.OtelRezervasyon.Entities.HotelFeatures;
import com.turizm.OtelRezervasyon.Entities.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HotelMapper {

    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    Hotel createHotelMapper(CreateHotelRequest createHotelRequest);

    @Mapping(target = "id", ignore = true)
    Hotel updateHotelMapper(UpdateHotelRequest updateHotelRequest, @MappingTarget Hotel hotel);

    GetByIdHotelResponse getByIdHotelResponse(Hotel hotel);

    GetAllHotelResponse getAllHotelResponse(Hotel hotels);
    List<GetAllHotelResponse> hotelToListHotelResponse(List<Hotel> hotels);




    @Mapping(source = "hotel.id", target = "hotelId")
    @Mapping(source = "rooms", target = "rooms")
    HotelWithRoomResponse hotelToHotelWithRoomResponse(Hotel hotel);

    @Mapping(source = "id", target = "hotelId")
    GetAllRoomResponse roomToGetAllRoomResponse(Room room);



    @Mapping(source = "id", target = "hotelId")
    @Mapping(source = "features", target = "hotelFeatures")
    HotelWithHotelFeaturesResponse hotelToHotelWithHotelFeaturesResponse(Hotel hotel);

    @Mapping(source = "id", target = "hotelId")
    GetAllHotelFeaturesResponse hotelFeaturesToGetAllHotelFeaturesResponse(HotelFeatures hotelFeatures);

}


