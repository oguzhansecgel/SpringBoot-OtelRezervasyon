package com.turizm.OtelRezervasyon.Core.Mapper;

import com.turizm.OtelRezervasyon.Core.Dto.Request.HotelFeatures.CreateHotelFeaturesRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.HotelFeatures.UpdateHotelFeaturesRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Response.HotelFeatures.GetAllHotelFeaturesResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.HotelFeatures.GetByIdHotelFeaturesResponse;
import com.turizm.OtelRezervasyon.Entities.HotelFeatures;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HotelFeaturesMapper {
    HotelFeaturesMapper INSTANCE = Mappers.getMapper(HotelFeaturesMapper.class);

    @Mapping(source = "hotelId",target = "hotel.id")
    HotelFeatures createHotelFeaturesWithHotelId(CreateHotelFeaturesRequest request);

    @Mapping(source = "hotelId",target = "hotel.id")
    HotelFeatures updateHotelFeaturesWithHotelId(UpdateHotelFeaturesRequest request, @MappingTarget HotelFeatures hotelFeatures);

    GetByIdHotelFeaturesResponse getByIdHotelFeaturesResponse(HotelFeatures hotelFeatures);

    @Mapping(source = "hotel.id",target = "hotelId")
    GetAllHotelFeaturesResponse getAllHotelFeaturesResponse(HotelFeatures hotelFeatures);
    List<GetAllHotelFeaturesResponse> GetAllHotelFeaturesResponse(List<HotelFeatures> hotelFeatures);
}
