package com.zuvsapp.shopapi.service.mapper;

import org.mapstruct.Mapper;

import com.zuvsapp.shopapi.service.model.ShopServiceResponse;
import com.zuvsapp.shopapi.service.repo.model.ShopView;

@Mapper
public interface ShopViewToServiceResponseMapper {

    ShopServiceResponse shopViewToServiceResponse(ShopView shopView);
}
