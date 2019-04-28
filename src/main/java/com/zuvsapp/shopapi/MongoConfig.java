package com.zuvsapp.shopapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;

/**
 * Mongo Configuration.
 */
@Configuration
public class MongoConfig {


    /**
     * @return MongoClient
     */
    @SuppressWarnings(value="unused")
    @Bean
    public MongoClient mongoClient(@Value("${spring.data.mongodb.uri}") String uri) {
        MongoClientURI mongoClientURI = new MongoClientURI(uri, MongoClientOptions.builder());
        return new MongoClient(mongoClientURI);
    }
}