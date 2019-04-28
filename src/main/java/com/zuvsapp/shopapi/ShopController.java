package com.zuvsapp.shopapi;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zuvsapp.shopapi.mapper.ShopServiceResponseToPresentationResponseMapper;
import com.zuvsapp.shopapi.model.ShopPresentationResponse;
import com.zuvsapp.shopapi.service.ShopService;
import com.zuvsapp.shopapi.service.model.ShopServiceResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/")
@Slf4j
public class ShopController {

    private ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    private ShopServiceResponseToPresentationResponseMapper MAPPER = Mappers.getMapper(ShopServiceResponseToPresentationResponseMapper.class);

    @GetMapping(path="/shop/{id}")
    public ResponseEntity<ShopPresentationResponse> getShopById(@PathVariable("id") String id) {

        log.info("Controller request received for shop {}", id);
        ShopServiceResponse response = shopService.getShopById(id);

        if (response == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(MAPPER.shopServiceResponseToPresentationResponseMapper(response), HttpStatus.OK);
    }
}