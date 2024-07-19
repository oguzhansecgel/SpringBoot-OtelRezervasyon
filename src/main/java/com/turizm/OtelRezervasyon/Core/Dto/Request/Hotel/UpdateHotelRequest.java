package com.turizm.OtelRezervasyon.Core.Dto.Request.Hotel;

import com.turizm.OtelRezervasyon.Entities.HotelType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateHotelRequest {
    private int id;
    private String hotelName;
    private String adress;
    private String email;
    private String phoneNumber;
    private int stars;
    private HotelType hotelType;
}
