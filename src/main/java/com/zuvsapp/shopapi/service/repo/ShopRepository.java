package com.zuvsapp.shopapi.service.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends MongoRepository<ShopView, String> {

    /**
     * Finds shop my the ID passed
     * @param id id of shop
     * @return {@link ShopView}
     */
    ShopView findShopById(String id);
}
