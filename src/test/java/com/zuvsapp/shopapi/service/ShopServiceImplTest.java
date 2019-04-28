package com.zuvsapp.shopapi.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.zuvsapp.shopapi.service.model.ShopServiceResponse;
import com.zuvsapp.shopapi.service.repo.ShopRepository;
import com.zuvsapp.shopapi.service.repo.model.ShopView;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShopServiceImplTest {

    @InjectMocks
    private ShopServiceImpl service;

    @Mock
    private ShopRepository repository;

    @Test
    @DisplayName("Tests the shop service returns shop data for an id")
    void testRetrievalOfShop() {
        ShopView view = createShopView();
        when(repository.findShopById(any())).thenReturn(view);

        ShopServiceResponse response = service.getShopById("1");

        assertNotNull(response);
    }

    @Test
    @DisplayName("Tests the shop service returns no shop data for an id")
    void testRetrievalOfShopWhenNotFound() {
        when(repository.findShopById(any())).thenReturn(null);

        ShopServiceResponse response = service.getShopById("1");

        assertNull(response);
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