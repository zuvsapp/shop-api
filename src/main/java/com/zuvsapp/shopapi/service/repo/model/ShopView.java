package com.zuvsapp.shopapi.service.repo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(value="shops")
public class ShopView {

    @Id
    String id;
    String country;
    String city;
    String size;
}
