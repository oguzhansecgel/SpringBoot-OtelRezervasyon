package com.turizm.OtelRezervasyon.Core.Mapper;

import com.turizm.OtelRezervasyon.Core.Dto.Request.Hotel.CreateHotelRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.Hotel.UpdateHotelRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel.GetAllHotelResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel.GetByIdHotelResponse;
import com.turizm.OtelRezervasyon.Entities.Hotel;
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
}


