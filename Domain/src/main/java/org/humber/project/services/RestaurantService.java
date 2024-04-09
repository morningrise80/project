package org.humber.project.services;

import org.humber.project.domain.Restaurant;

public interface RestaurantService {
    Restaurant createRestaurant(Restaurant restaurant);

    boolean deleteRestaurant(Long restaurantId);

    Restaurant updateRestaurant(Restaurant restaurant);

    Restaurant getRestaurant(Long restaurantId);
}
