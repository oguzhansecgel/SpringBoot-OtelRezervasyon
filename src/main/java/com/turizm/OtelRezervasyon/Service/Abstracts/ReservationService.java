package com.turizm.OtelRezervasyon.Service.Abstracts;

import com.turizm.OtelRezervasyon.Core.Dto.Request.Reservation.CreateReservationRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.Reservation.UpdateReservationRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Reservation.CreateReservationResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Reservation.GetAllReservationResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Reservation.UpdateReservationResponse;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

    List<GetAllReservationResponse> getAllReservations();
    CreateReservationResponse createReservation(CreateReservationRequest request);
    UpdateReservationResponse updateReservation(UpdateReservationRequest request, Integer id);
    void deleteReservation(Integer id);



    boolean isRoomAvailable(int roomId, LocalDate checkIn, LocalDate checkOut);
}
