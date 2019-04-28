package com.zuvsapp.shopapi.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.zuvsapp.shopapi.model.ShopPresentationResponse;
import com.zuvsapp.shopapi.service.model.ShopServiceResponse;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ShopServiceResponseToPresentationResponseMapperTest {

    private ShopServiceResponseToPresentationResponseMapper MAPPER = Mappers.getMapper(ShopServiceResponseToPresentationResponseMapper.class);

    @Test
    @DisplayName("Tests mapping works from a service response object to a presentation response object")
    void testServiceResponseToPresentationResponseMapping() {
        ShopServiceResponse serviceResponse = createShopResponse();
        ShopPresentationResponse presentationResponse = MAPPER.shopServiceResponseToPresentationResponseMapper(serviceResponse);

        assertAll("All fields have been correctly mapped",
            () -> assertEquals(presentationResponse.getId(), serviceResponse.getId()),
            () -> assertEquals(presentationResponse.getCountry(), serviceResponse.getCountry()),
            () -> assertEquals(presentationResponse.getCity(), serviceResponse.getCity()),
            () -> assertEquals(presentationResponse.getSize(), serviceResponse.getSize()));

    }

    private ShopServiceResponse createShopResponse() {
        return ShopServiceResponse.builder()
            .id("1")
            .country("Wales")
            .city("Swansea")
            .size("medium")
            .build();
    }
}
