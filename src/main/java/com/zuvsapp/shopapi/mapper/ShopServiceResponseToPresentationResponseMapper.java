package com.zuvsapp.shopapi.mapper;

import org.mapstruct.Mapper;

import com.zuvsapp.shopapi.model.ShopPresentationResponse;
import com.zuvsapp.shopapi.service.model.ShopServiceResponse;

@Mapper
public interface ShopServiceResponseToPresentationResponseMapper {

    ShopPresentationResponse shopServiceResponseToPresentationResponseMapper(ShopServiceResponse shopView);
}
