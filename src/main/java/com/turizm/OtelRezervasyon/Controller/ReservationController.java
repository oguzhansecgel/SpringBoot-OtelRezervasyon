package com.turizm.OtelRezervasyon.Controller;

import com.turizm.OtelRezervasyon.Core.Dto.Request.Reservation.CreateReservationRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.Reservation.UpdateReservationRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Reservation.CreateReservationResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Reservation.GetAllReservationResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Reservation.UpdateReservationResponse;
import com.turizm.OtelRezervasyon.Service.Abstracts.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @GetMapping("/getAll")
    public List<GetAllReservationResponse> getAllReservationResponse()
    {
        return reservationService.getAllReservations();
    }
    @DeleteMapping("/deleteReservation/{id}")
    public void deleteReservation(@PathVariable int id)
    {
        reservationService.deleteReservation(id);
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
