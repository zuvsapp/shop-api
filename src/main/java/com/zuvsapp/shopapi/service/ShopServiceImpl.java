package com.zuvsapp.shopapi.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuvsapp.shopapi.service.mapper.ShopViewToServiceResponseMapper;
import com.zuvsapp.shopapi.service.model.ShopServiceResponse;
import com.zuvsapp.shopapi.service.repo.ShopRepository;
import com.zuvsapp.shopapi.service.repo.model.ShopView;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ShopServiceImpl implements ShopService {

    private ShopRepository shopRepository;

    private ShopViewToServiceResponseMapper MAPPER;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
        this.MAPPER = Mappers.getMapper(ShopViewToServiceResponseMapper.class);
    }

    @Override
    public ShopServiceResponse getShopById(String id) {

        log.info("Calling repository for shop id: {}", id);
        ShopView shopView = shopRepository.findShopById(id);
        log.info("Response from repository {}", shopView);

        return MAPPER.shopViewToServiceResponse(shopView);
    }
}
