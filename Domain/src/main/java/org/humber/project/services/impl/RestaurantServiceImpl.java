package org.humber.project.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.humber.project.domain.Restaurant;
import org.humber.project.exceptions.ErrorCode;
import org.humber.project.exceptions.RestaurantValidationException;
import org.humber.project.services.RestaurantJPAService;
import org.humber.project.services.RestaurantService;
import org.humber.project.services.RestaurantValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantJPAService restaurantJpaService;
    private final List<RestaurantValidationService> validationServices;

    @Autowired
    public RestaurantServiceImpl(RestaurantJPAService restaurantJpaService, List<RestaurantValidationService> validationService) {
        this.restaurantJpaService = restaurantJpaService;
        this.validationServices = validationService;
    }

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        log.info("In method createRestaurant, validating restaurant= {}", restaurant);
        for (RestaurantValidationService validationService : validationServices) {
            if (validationService instanceof RestaurantIdValidation) {
                log.info("Skipping RestaurantIdValidation for new Restaurant...");
                continue;
            }
            validationService.validateRestaurant(restaurant);
        }
        log.info("Saving restaurant...");
        return restaurantJpaService.saveRestaurant(restaurant);
    }

    @Override
    public boolean deleteRestaurant(Long restaurantId) {
        log.info("Deleting restaurant...");
        return restaurantJpaService.deleteRestaurant(restaurantId);
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        log.info("In method updateRestaurant, validating restaurant= {}", restaurant);
        for (RestaurantValidationService validationService : validationServices) {
            validationService.validateRestaurant(restaurant);
        }
        log.info("Updating restaurant...");
        return restaurantJpaService.updateRestaurant(restaurant);
    }

    @Override
    public Restaurant getRestaurant(Long restaurantId) {
        log.info("Getting restaurant for ID= {}", restaurantId);
        if (restaurantId == null) {
            System.err.println("Restaurant ID is null.");
            throw new RestaurantValidationException(ErrorCode.INVALID_RESTAURANT_ID);
        }
        return restaurantJpaService.getRestaurantById(restaurantId);
    }
}
