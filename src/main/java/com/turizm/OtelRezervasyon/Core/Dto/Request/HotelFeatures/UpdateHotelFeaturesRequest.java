package com.turizm.OtelRezervasyon.Core.Dto.Request.HotelFeatures;


import com.turizm.OtelRezervasyon.Entities.Hotel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateHotelFeaturesRequest {

    private int id;

    private boolean hasFreeParking;

    private boolean hasFreeWiFi;

    private boolean hasSwimmingPool;

    private boolean hasFitnessCenter;

    private boolean hasHotelConcierge;

    private boolean hasSPA;

    private boolean hasRoomService24_7;

    private int hotelId;
}
