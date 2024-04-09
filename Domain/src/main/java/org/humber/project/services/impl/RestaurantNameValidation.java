package org.humber.project.services.impl;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.humber.project.domain.Restaurant;
import org.humber.project.exceptions.ErrorCode;
import org.humber.project.exceptions.RestaurantValidationException;
import org.humber.project.services.RestaurantValidationService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Slf4j
public class RestaurantNameValidation implements RestaurantValidationService {
    @Override
    public void validateRestaurant(@NonNull Restaurant restaurant) {
        if (restaurant.getName() == null || !StringUtils.hasLength(restaurant.getName().trim())) {
            log.error("Restaurant name is null.");
            throw new RestaurantValidationException(ErrorCode.INVALID_RESTAURANT_NAME);
        }
    }
}
