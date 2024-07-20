package com.turizm.OtelRezervasyon.Core.Dto.Response.Room;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT) // false değerleri jsonda bastırmaz
public class TrueRoomWithFeaturesResponse {
    private int id;

    private int bedCount;

    private double squareMeters;

    private boolean hasTelevision;

    private boolean hasMinibar;

    private boolean hasGameConsole;

    private boolean hasSafe;

    private boolean hasProjector;

    private double price;

    private int hotelId;
}
