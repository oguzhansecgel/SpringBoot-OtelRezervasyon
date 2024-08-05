package com.turizm.OtelRezervasyon.Service;

import com.turizm.OtelRezervasyon.Core.Dto.Request.HotelFeatures.CreateHotelFeaturesRequest;
import com.turizm.OtelRezervasyon.Core.Dto.Response.HotelFeatures.CreateHotelFeaturesResponse;
import com.turizm.OtelRezervasyon.Core.Mapper.HotelFeaturesMapper;
import com.turizm.OtelRezervasyon.Entities.Hotel;
import com.turizm.OtelRezervasyon.Entities.HotelFeatures;
import com.turizm.OtelRezervasyon.Repositories.HotelFeaturesRepository;
import com.turizm.OtelRezervasyon.Service.Concretes.HotelFeaturesServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

@SpringBootTest
public class HotelFeaturesTest {

    @InjectMocks
    private HotelFeaturesServiceImpl hotelFeaturesService;

    @Mock
    private HotelFeaturesRepository hotelFeaturesRepository;

    @Mock
    private HotelFeaturesMapper hotelFeaturesMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_Success_When_AddHotelFeatures() {
        CreateHotelFeaturesRequest request = new CreateHotelFeaturesRequest();
        request.setHotelId(1);
        request.setHasFreeParking(true);
        request.setHasFreeWiFi(true);
        request.setHasSwimmingPool(true);
        request.setHasFitnessCenter(true);
        request.setHasHotelConcierge(true);
        request.setHasSPA(true);
        request.setHasRoomService24_7(true);

        HotelFeatures hotelFeatures = new HotelFeatures();
        hotelFeatures.setId(1);
        // Diğer alanları da ayarla
        Hotel hotel = new Hotel();
        hotel.setId(1);
        hotelFeatures.setHotel(hotel);

        // Mock davranışlarını ayarla
        when(hotelFeaturesRepository.findByHotelId(request.getHotelId())).thenReturn(Optional.empty());
        when(hotelFeaturesMapper.createHotelFeaturesWithHotelId(request)).thenReturn(hotelFeatures);
        when(hotelFeaturesRepository.save(any(HotelFeatures.class))).thenReturn(hotelFeatures);

        CreateHotelFeaturesResponse response = hotelFeaturesService.createHotelFeaturesWithHotelId(request);

        assertNotNull(response);
        assertEquals(hotelFeatures.getId(), response.getId());
    }
}
