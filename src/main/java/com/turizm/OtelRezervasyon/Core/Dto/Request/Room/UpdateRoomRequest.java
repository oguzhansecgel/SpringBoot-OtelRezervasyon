package com.turizm.OtelRezervasyon.Core.Dto.Request.Room;

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
public class UpdateRoomRequest {

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
