package com.turizm.OtelRezervasyon.Service.Concretes;

import com.turizm.OtelRezervasyon.Core.Dto.Request.Reservation.CreateReservationRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.Reservation.UpdateReservationRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Reservation.CreateReservationResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Reservation.GetAllReservationResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Reservation.UpdateReservationResponse;
import com.turizm.OtelRezervasyon.Core.Mapper.HotelMapper;
import com.turizm.OtelRezervasyon.Core.Mapper.ReservationMapper;
import com.turizm.OtelRezervasyon.Entities.Hotel;
import com.turizm.OtelRezervasyon.Entities.Reservation;
import com.turizm.OtelRezervasyon.Entities.Room;
import com.turizm.OtelRezervasyon.Repositories.HotelRepository;
import com.turizm.OtelRezervasyon.Repositories.ReservationRepository;
import com.turizm.OtelRezervasyon.Repositories.RoomRepository;
import com.turizm.OtelRezervasyon.Service.Abstracts.ReservationService;
import org.springframework.stereotype.Service;
import org.turkcell.tcell.exception.exceptions.type.BaseBusinessException;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {


    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<GetAllReservationResponse> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return ReservationMapper.INSTANCE.reservationToListReservationResponse(reservations);
    }

    @Override
    public CreateReservationResponse createReservation(CreateReservationRequest request) {
        Room room = roomRepository.findById(request.getRoomId())
                .orElseThrow(() -> new BaseBusinessException("Room not found"));
        Hotel hotel = hotelRepository.findById(request.getHotelId())
                .orElseThrow(() -> new BaseBusinessException("Hotel not found"));

        int bedCount = room.getBedCount();
        int customerCount = request.getAdultCount()+request.getChildCount();
        if(customerCount > bedCount){
            throw new BaseBusinessException("Customer count exceeds bed count");
        }
        Reservation reservation = ReservationMapper.INSTANCE.createReservation(request);

        reservation.setRoom(room);
        boolean roomCheck = isRoomAvailable(request.getRoomId(),request.getCheckIn(),request.getCheckOut());
        if(!roomCheck){
            throw new BaseBusinessException("Room is not available");
        }
        Reservation savedReservation = reservationRepository.save(reservation);

        double roomPrice = savedReservation.getRoom().getPrice();

        double totalPrice = (request.getAdultCount() * roomPrice) + (request.getChildCount() * roomPrice * 0.75);

        savedReservation.setTotalPrice(totalPrice);

        return new CreateReservationResponse(
                savedReservation.getId(),
                savedReservation.getCustomerName(),
                savedReservation.getCustomerSurname(),
                savedReservation.getCustomerIdentityNo(),
                savedReservation.getAdultCount(),
                savedReservation.getChildCount(),
                savedReservation.getTotalPrice(),
                savedReservation.getCheckIn(),
                savedReservation.getCheckOut(),
                savedReservation.getHotel().getId(),
                savedReservation.getRoom().getId()
        );
    }

    @Override
    public UpdateReservationResponse updateReservation(UpdateReservationRequest request, Integer id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        Reservation existingReservation = reservationOptional.get();
        Reservation reservation = ReservationMapper.INSTANCE.updateReservation(request, existingReservation);
        Reservation savedReservation = reservationRepository.save(reservation);
        return new UpdateReservationResponse(savedReservation.getId(),
                savedReservation.getCustomerName(),
                savedReservation.getCustomerSurname(),
                savedReservation.getCustomerIdentityNo(),
                savedReservation.getAdultCount(),
                savedReservation.getChildCount(),
                savedReservation.getTotalPrice(),
                savedReservation.getCheckIn(),
                savedReservation.getCheckOut(),
                savedReservation.getHotel().getId(),
                savedReservation.getRoom().getId());
    }

    @Override
    public void deleteReservation(Integer id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new BaseBusinessException("Room not found"));
        reservationRepository.deleteById(id);
    }

    @Override
    public boolean isRoomAvailable(int roomId, LocalDate checkIn, LocalDate checkOut) {
        return !reservationRepository.isRoomOccupied(roomId, checkIn, checkOut);
    }
}
