package com.turizm.OtelRezervasyon.Core.Dto.Request.Reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateReservationRequest {
    private int id;
    private String customerName;
    private String customerSurname;
    private String customerIdentityNo;
    private int adultCount;
    private int childCount;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int hotelId;
    private int roomId;
}
