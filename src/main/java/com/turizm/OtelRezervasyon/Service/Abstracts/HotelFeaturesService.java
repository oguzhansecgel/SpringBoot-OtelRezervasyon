package com.turizm.OtelRezervasyon.Service.Abstracts;

import com.turizm.OtelRezervasyon.Core.Dto.Request.HotelFeatures.CreateHotelFeaturesRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.HotelFeatures.UpdateHotelFeaturesRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Response.HotelFeatures.CreateHotelFeaturesResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.HotelFeatures.GetAllHotelFeaturesResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.HotelFeatures.GetByIdHotelFeaturesResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.HotelFeatures.UpdateHotelFeaturesResponse;

import java.util.List;
import java.util.Optional;

public interface HotelFeaturesService {

    CreateHotelFeaturesResponse createHotelFeaturesWithHotelId(CreateHotelFeaturesRequest request);
    UpdateHotelFeaturesResponse updateHotelFeaturesWithHotelId(UpdateHotelFeaturesRequest request, Integer id);
    void deleteHotelFeatures(Integer id);
    Optional<GetByIdHotelFeaturesResponse> getByIdHotelFeatures(Integer id);
    List<GetAllHotelFeaturesResponse> getAllHotelFeatures();
}
