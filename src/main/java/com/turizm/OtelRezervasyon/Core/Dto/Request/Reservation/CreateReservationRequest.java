package com.turizm.OtelRezervasyon.Core.Dto.Request.Reservation;

import com.turizm.OtelRezervasyon.Entities.Hotel;
import com.turizm.OtelRezervasyon.Entities.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateReservationRequest {

    private String customerName;
    private String customerSurname;
    private String customerIdentityNo;
    private int adultCount;
    private int childCount;
    private double totalPrice;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int hotelId;
    private int roomId;
}
