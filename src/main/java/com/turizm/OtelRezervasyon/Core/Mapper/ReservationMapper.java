package com.turizm.OtelRezervasyon.Core.Mapper;

import com.turizm.OtelRezervasyon.Core.Dto.Request.Reservation.CreateReservationRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.Reservation.UpdateReservationRequest;
import com.turizm.OtelRezervasyon.Entities.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

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
}
