package org.humber.project.services.impl;

import lombok.NonNull;
import org.humber.project.domain.Restaurant;
import org.humber.project.exceptions.ErrorCode;
import org.humber.project.exceptions.RestaurantValidationException;
import org.humber.project.services.RestaurantValidationService;
import org.springframework.stereotype.Component;

@Component
public class RestaurantIdValidation implements RestaurantValidationService {
    @Override
    public void validateRestaurant(@NonNull Restaurant restaurant) {
        if(restaurant.getRestaurantId() == null) {
            System.err.println("Restaurant ID is null.");
            throw new RestaurantValidationException(ErrorCode.INVALID_RESTAURANT_ID);
        }
    }
}
