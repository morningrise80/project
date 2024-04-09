package org.humber.project.services.impl;

import org.humber.project.domain.Restaurant;
import org.humber.project.repositories.RestaurantJPARepository;
import org.humber.project.repositories.entities.RestaurantEntity;
import org.humber.project.services.RestaurantJPAService;
import org.humber.project.transformers.RestaurantEntityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.humber.project.transformers.RestaurantEntityTransformer.transformToRestaurant;
import static org.humber.project.transformers.RestaurantEntityTransformer.transformToRestaurantEntity;

@Service
public class RestaurantJPAServiceImpl implements RestaurantJPAService {

    private final RestaurantJPARepository restaurantJPARepository;

    @Autowired
    public RestaurantJPAServiceImpl(RestaurantJPARepository restaurantJPARepository) {
        this.restaurantJPARepository = restaurantJPARepository;
    }

    @Override
    public Restaurant getRestaurantById(Long restaurantId) {
        return restaurantJPARepository.findById(restaurantId)
                .map(RestaurantEntityTransformer::transformToRestaurant)
                .orElse(null);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return Optional.of(restaurantJPARepository.findAll())
                .map(RestaurantEntityTransformer::transformToRestaurants)
                .orElse(null);
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        RestaurantEntity restaurantEntity = transformToRestaurantEntity(restaurant);
        RestaurantEntity savedEntity = restaurantJPARepository.save(restaurantEntity);
        return transformToRestaurant(savedEntity);
    }

    @Override
    public boolean deleteRestaurant(Long restaurantId) {
        Optional<RestaurantEntity> restaurantEntity = restaurantJPARepository.findById(restaurantId);
        if (restaurantEntity.isEmpty()) {
            return false;
        }
        restaurantJPARepository.delete(restaurantEntity.get());
        return true;
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        return saveRestaurant(restaurant);
    }
}
