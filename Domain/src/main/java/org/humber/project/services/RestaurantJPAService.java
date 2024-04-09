package org.humber.project.services;

import org.humber.project.domain.Restaurant;

import java.util.List;

public interface RestaurantJPAService {
    Restaurant getRestaurantById(Long restaurantId);

    List<Restaurant> getAllRestaurants();

    Restaurant saveRestaurant(Restaurant restaurant);

    boolean deleteRestaurant(Long restaurantId);

    Restaurant updateRestaurant(Restaurant restaurant);
}
