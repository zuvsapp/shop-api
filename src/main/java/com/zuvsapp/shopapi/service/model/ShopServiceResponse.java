package com.zuvsapp.shopapi.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ShopServiceResponse {
    String id;
    String country;
    String city;
    String size;
}
