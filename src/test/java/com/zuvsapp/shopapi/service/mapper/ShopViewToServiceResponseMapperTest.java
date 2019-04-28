package com.zuvsapp.shopapi.service.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.zuvsapp.shopapi.service.model.ShopServiceResponse;
import com.zuvsapp.shopapi.service.repo.model.ShopView;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ShopViewToServiceResponseMapperTest {

    private ShopViewToServiceResponseMapper MAPPER = Mappers.getMapper(ShopViewToServiceResponseMapper.class);

    @Test
    @DisplayName("Tests mapping works from a view object to a service response object")
    void testViewToServiceResponseMapping() {
        ShopView view = createShopView();
        ShopServiceResponse serviceResponse = MAPPER.shopViewToServiceResponse(view);

        assertAll("All fields have been correctly mapped",
            () -> assertEquals(serviceResponse.getId(), view.getId()),
            () -> assertEquals(serviceResponse.getCountry(), view.getCountry()),
            () -> assertEquals(serviceResponse.getCity(), view.getCity()),
            () -> assertEquals(serviceResponse.getSize(), view.getSize()));

    }

    private ShopView createShopView() {
        return ShopView.builder()
            .id("1")
            .country("Wales")
            .city("Swansea")
            .size("medium")
            .build();
    }
}
