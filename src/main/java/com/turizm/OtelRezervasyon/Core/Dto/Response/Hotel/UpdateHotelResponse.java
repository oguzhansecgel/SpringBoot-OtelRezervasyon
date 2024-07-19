package com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel;

import com.turizm.OtelRezervasyon.Entities.HotelType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateHotelResponse {
    private int id;
    private String hotelName;
    private String adress;
    private String email;
    private String phoneNumber;
    private int stars;
    private HotelType hotelType;
}
