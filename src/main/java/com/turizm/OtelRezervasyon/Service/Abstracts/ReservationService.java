package com.turizm.OtelRezervasyon.Service.Abstracts;

import com.turizm.OtelRezervasyon.Core.Dto.Request.Reservation.CreateReservationRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.Reservation.UpdateReservationRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Reservation.CreateReservationResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Reservation.UpdateReservationResponse;

public interface ReservationService {

    CreateReservationResponse createReservation(CreateReservationRequest request);
    UpdateReservationResponse updateReservation(UpdateReservationRequest request, Integer id);
}
