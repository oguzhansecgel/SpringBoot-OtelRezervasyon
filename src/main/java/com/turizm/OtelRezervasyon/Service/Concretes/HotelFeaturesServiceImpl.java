package com.turizm.OtelRezervasyon.Service.Concretes;

import com.turizm.OtelRezervasyon.Core.Dto.Request.HotelFeatures.CreateHotelFeaturesRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Request.HotelFeatures.UpdateHotelFeaturesRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Response.HotelFeatures.CreateHotelFeaturesResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.HotelFeatures.GetAllHotelFeaturesResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.HotelFeatures.GetByIdHotelFeaturesResponse;
import com.turizm.OtelRezervasyon.Core.Dto.Response.HotelFeatures.UpdateHotelFeaturesResponse;
import com.turizm.OtelRezervasyon.Core.Mapper.HotelFeaturesMapper;
import com.turizm.OtelRezervasyon.Core.Mapper.HotelMapper;
import com.turizm.OtelRezervasyon.Entities.HotelFeatures;
import com.turizm.OtelRezervasyon.Repositories.HotelFeaturesRepository;
import com.turizm.OtelRezervasyon.Service.Abstracts.HotelFeaturesService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class HotelFeaturesServiceImpl implements HotelFeaturesService {

    private HotelFeaturesRepository hotelFeaturesRepository;

    @Autowired
    public HotelFeaturesServiceImpl(HotelFeaturesRepository hotelFeaturesRepository) {
        this.hotelFeaturesRepository = hotelFeaturesRepository;
    }

    public HotelFeaturesServiceImpl() {
    }

    @Override
    public CreateHotelFeaturesResponse createHotelFeaturesWithHotelId(CreateHotelFeaturesRequest request) {
        Optional<HotelFeatures> existByHotelId=hotelFeaturesRepository.findByHotelId(request.getHotelId());
        if(existByHotelId.isPresent()) {
            throw new RuntimeException("Bu otele ait özellik daha önce girilmiştir.");
        }
        HotelFeatures hotelFeatures = HotelFeaturesMapper.INSTANCE.createHotelFeaturesWithHotelId(request);
        HotelFeatures savedHotelFeatures = hotelFeaturesRepository.save(hotelFeatures);
        return new CreateHotelFeaturesResponse(savedHotelFeatures.getId()
                ,savedHotelFeatures.isHasFreeParking()
                ,savedHotelFeatures.isHasFreeWiFi()
                ,savedHotelFeatures.isHasSwimmingPool()
                ,savedHotelFeatures.isHasFitnessCenter()
                ,savedHotelFeatures.isHasHotelConcierge()
                ,savedHotelFeatures.isHasSPA()
                ,savedHotelFeatures.isHasRoomService24_7()
                ,savedHotelFeatures.getHotel().getId());
    }

    @Override
    public UpdateHotelFeaturesResponse updateHotelFeaturesWithHotelId(UpdateHotelFeaturesRequest request, Integer id) {
        Optional<HotelFeatures> hotelFeaturesOptional=hotelFeaturesRepository.findById(id);
        HotelFeatures existingHotelFeatures=hotelFeaturesOptional.get();
        HotelFeatures hotelFeatures = HotelFeaturesMapper.INSTANCE.updateHotelFeaturesWithHotelId(request,existingHotelFeatures);
        HotelFeatures savedHotelFeatures = hotelFeaturesRepository.save(hotelFeatures);
        return new UpdateHotelFeaturesResponse(savedHotelFeatures.getId()
                ,savedHotelFeatures.isHasFreeParking()
                ,savedHotelFeatures.isHasFreeWiFi()
                ,savedHotelFeatures.isHasSwimmingPool()
                ,savedHotelFeatures.isHasFitnessCenter()
                ,savedHotelFeatures.isHasHotelConcierge()
                ,savedHotelFeatures.isHasSPA()
                ,savedHotelFeatures.isHasRoomService24_7()
                ,savedHotelFeatures.getHotel().getId());
    }

    @Override
    public void deleteHotelFeatures(Integer id) {
            hotelFeaturesRepository.deleteById(id);
    }

    @Override
    public Optional<GetByIdHotelFeaturesResponse> getByIdHotelFeatures(Integer id) {
        Optional<HotelFeatures> existingHotelFeatures=hotelFeaturesRepository.findById(id);
        return existingHotelFeatures.map(HotelFeaturesMapper.INSTANCE::getByIdHotelFeaturesResponse);
    }

    @Override
    public List<GetAllHotelFeaturesResponse> getAllHotelFeatures() {
        List<HotelFeatures> hotelFeaturesList = hotelFeaturesRepository.findAll();
        return HotelFeaturesMapper.INSTANCE.GetAllHotelFeaturesResponse(hotelFeaturesList);
    }
}
