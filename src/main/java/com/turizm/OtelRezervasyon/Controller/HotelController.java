package com.turizm.OtelRezervasyon.Controller;

import com.turizm.OtelRezervasyon.Core.Dto.Request.Hotel.CreateHotelRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.Hotel.UpdateHotelRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel.CreateHotelResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel.GetAllHotelResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel.GetByIdHotelResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.Hotel.UpdateHotelResponse;
import com.turizm.OtelRezervasyon.Service.Abstracts.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/hotel")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    @GetMapping("/getAll")
    public List<GetAllHotelResponse> getAllHotelResponse()
    {
        return hotelService.getAllHotel();
    }
    @GetMapping("/getById/{id}")
    public Optional<GetByIdHotelResponse> getByIdHotelResponses(@PathVariable int id)
    {
        return hotelService.getByIdHotel(id);
    }
    @PostMapping("/create")
    public CreateHotelResponse createHotel(@RequestBody CreateHotelRequest hotel)
    {
        return hotelService.createHotel(hotel);

    }
    @PutMapping("/update/{id}")
    public UpdateHotelResponse updateHotelResponse(@RequestBody UpdateHotelRequest hotel,@PathVariable int id )
    {
        return hotelService.updateHotel(hotel, id);

    }
    @DeleteMapping("/deleteHotel/{id}")
    public void deletedHotel(@PathVariable int id)
    {
        hotelService.deletedHotel(id);
    }
}
