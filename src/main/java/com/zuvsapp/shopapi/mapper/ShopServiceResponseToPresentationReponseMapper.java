package com.zuvsapp.shopapi.mapper;

import org.mapstruct.Mapper;

import com.zuvsapp.shopapi.model.ShopPresentationResponse;
import com.zuvsapp.shopapi.service.model.ShopServiceResponse;
import com.zuvsapp.shopapi.service.repo.ShopView;

@Mapper
public interface ShopServiceResponseToPresentationReponseMapper {

    ShopPresentationResponse shopServiceResponseToPresentationResponseMapper(ShopServiceResponse shopView);
}
