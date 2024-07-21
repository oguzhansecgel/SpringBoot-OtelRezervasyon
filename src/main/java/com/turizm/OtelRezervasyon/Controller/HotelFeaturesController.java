package com.turizm.OtelRezervasyon.Controller;

import com.turizm.OtelRezervasyon.Core.Dto.Request.HotelFeatures.CreateHotelFeaturesRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.HotelFeatures.UpdateHotelFeaturesRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Response.HotelFeatures.CreateHotelFeaturesResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.HotelFeatures.GetAllHotelFeaturesResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.HotelFeatures.GetByIdHotelFeaturesResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.HotelFeatures.UpdateHotelFeaturesResponse;
import com.turizm.OtelRezervasyon.Service.Abstracts.HotelFeaturesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/hotelfeatures")
public class HotelFeaturesController {
    private final HotelFeaturesService hotelFeaturesService;

    public HotelFeaturesController(HotelFeaturesService hotelFeaturesService) {
        this.hotelFeaturesService = hotelFeaturesService;
    }
    @GetMapping("/getById/{id}")
    public Optional<GetByIdHotelFeaturesResponse> getByIdHotelFeaturesResponse(@PathVariable int id)
    {
        return hotelFeaturesService.getByIdHotelFeatures(id);
    }
    @GetMapping("/getAll")
    public List<GetAllHotelFeaturesResponse> getAllHotelFeatures() {
        return hotelFeaturesService.getAllHotelFeatures();
    }
    @PostMapping("/createFeaturesWithHotel")
    public CreateHotelFeaturesResponse createHotelFeaturesWithHotel(@RequestBody CreateHotelFeaturesRequest createHotelFeaturesRequest)
    {
        return hotelFeaturesService.createHotelFeaturesWithHotelId(createHotelFeaturesRequest);
    }
    @DeleteMapping("/delete/{id}")
    public void deletedHotelFeatures(@PathVariable int id)
    {
        hotelFeaturesService.deleteHotelFeatures(id);
    }
    @PutMapping("/updateFeatures/{id}")
    public UpdateHotelFeaturesResponse updateHotelFeaturesResponse(@PathVariable int id, @RequestBody UpdateHotelFeaturesRequest updateHotelFeaturesRequest)
    {
        return hotelFeaturesService.updateHotelFeaturesWithHotelId(updateHotelFeaturesRequest,id);
    }
}
