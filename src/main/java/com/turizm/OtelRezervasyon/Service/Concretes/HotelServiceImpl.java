package com.turizm.OtelRezervasyon.Service.Concretes;

import com.turizm.OtelRezervasyon.Core.Dto.Request.Hotel.CreateHotelRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.Hotel.UpdateHotelRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel.CreateHotelResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel.GetAllHotelResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel.GetByIdHotelResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel.UpdateHotelResponse;
import com.turizm.OtelRezervasyon.Core.Mapper.HotelMapper;
import com.turizm.OtelRezervasyon.Core.Mapper.RoomMapper;
import com.turizm.OtelRezervasyon.Entities.Hotel;
import com.turizm.OtelRezervasyon.Entities.Room;
import com.turizm.OtelRezervasyon.Repositories.HotelRepository;
import com.turizm.OtelRezervasyon.Service.Abstracts.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {


    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public CreateHotelResponse createHotel(CreateHotelRequest createHotelRequest) {
        Hotel hotel = HotelMapper.INSTANCE.createHotelMapper(createHotelRequest);
        Hotel savedHotel = hotelRepository.save(hotel);
        hotelRepository.save(savedHotel);
        return new CreateHotelResponse(savedHotel.getId(),savedHotel.getHotelName(), savedHotel.getAdress(), savedHotel.getEmail(),savedHotel.getPhoneNumber(),savedHotel.getStars(),savedHotel.getHotelType());
    }

    @Override
    public UpdateHotelResponse updateHotel(UpdateHotelRequest updateHotelRequest, Integer id) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(id);
        Hotel existingHotel = hotelOptional.get();
        Hotel hotel = HotelMapper.INSTANCE.updateHotelMapper(updateHotelRequest,existingHotel);
        Hotel savedHotel = hotelRepository.save(hotel);
        return new UpdateHotelResponse(savedHotel.getId()
                ,savedHotel.getHotelName()
                , savedHotel.getAdress()
                , savedHotel.getEmail()
                ,savedHotel.getPhoneNumber()
                ,savedHotel.getStars()
                ,savedHotel.getHotelType());
    }

    @Override
    public Optional<GetByIdHotelResponse> getByIdHotel(Integer id) {
        Optional<Hotel> existingHotel = hotelRepository.findById(id);
        return existingHotel.map(HotelMapper.INSTANCE::getByIdHotelResponse);
    }

    @Override
    public List<GetAllHotelResponse> getAllHotel() {
        List<Hotel> hotels = hotelRepository.findAll();

        return HotelMapper.INSTANCE.hotelToListHotelResponse(hotels);
    }

    @Override
    public void deletedHotel(Integer id) {
        hotelRepository.deleteById(id);
    }
}
