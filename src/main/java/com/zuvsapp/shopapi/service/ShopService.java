package com.zuvsapp.shopapi.service;

import com.zuvsapp.shopapi.service.model.ShopServiceResponse;

public interface ShopService {

    ShopServiceResponse getShopById(String id);
}
