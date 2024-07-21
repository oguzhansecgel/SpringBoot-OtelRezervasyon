package com.turizm.OtelRezervasyon.Controller;

import com.turizm.OtelRezervasyon.Core.Dto.Request.Reservation.CreateReservationRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.Reservation.UpdateReservationRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Reservation.CreateReservationResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Reservation.UpdateReservationResponse;
import com.turizm.OtelRezervasyon.Service.Abstracts.ReservationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/createReservation")
    public CreateReservationResponse createReservation(@RequestBody CreateReservationRequest createReservationRequest)
    {
        return reservationService.createReservation(createReservationRequest);
    }
    @PutMapping("/updateReservation/{id}")
    public UpdateReservationResponse updateReservation(@RequestBody UpdateReservationRequest updateReservationRequest,@PathVariable int id)
    {
        return reservationService.updateReservation(updateReservationRequest, id);
    }
}
