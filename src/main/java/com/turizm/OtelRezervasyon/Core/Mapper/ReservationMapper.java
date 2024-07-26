package com.turizm.OtelRezervasyon.Core.Mapper;

import com.turizm.OtelRezervasyon.Core.Dto.Request.Reservation.CreateReservationRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.Reservation.UpdateReservationRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel.GetAllHotelResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel.HotelWithRoomResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Reservation.GetAllReservationResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Room.GetAllRoomResponse;
import com.turizm.OtelRezervasyon.Entities.Hotel;
import com.turizm.OtelRezervasyon.Entities.Reservation;
import com.turizm.OtelRezervasyon.Entities.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReservationMapper {

    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    @Mapping(source = "hotelId", target = "hotel.id")
    @Mapping(source = "roomId", target = "room.id")
    @Mapping(source = "checkIn", target = "checkIn", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "checkOut", target = "checkOut", dateFormat = "yyyy-MM-dd")
    Reservation createReservation(CreateReservationRequest request);

    @Mapping(source = "hotelId", target = "hotel.id")
    @Mapping(source = "roomId", target = "room.id")
    @Mapping(source = "checkIn", target = "checkIn", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "checkOut", target = "checkOut", dateFormat = "yyyy-MM-dd")
    Reservation updateReservation(UpdateReservationRequest request, @MappingTarget Reservation reservation);


    GetAllReservationResponse getAllReservationResponse(Reservation reservation);
    List<GetAllReservationResponse> reservationToListReservationResponse(List<Reservation> reservations);
}
