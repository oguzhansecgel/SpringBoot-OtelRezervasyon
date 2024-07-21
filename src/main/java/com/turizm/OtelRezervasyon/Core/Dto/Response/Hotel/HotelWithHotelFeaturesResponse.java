package com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel;

import com.turizm.OtelRezervasyon.Core.Dto.Response.HotelFeatures.GetAllHotelFeaturesResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelWithHotelFeaturesResponse {
    private int hotelId;
    private List<GetAllHotelFeaturesResponse> hotelFeatures;
}
