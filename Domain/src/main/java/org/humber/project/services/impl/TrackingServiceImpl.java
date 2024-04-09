package org.humber.project.services.impl;

import org.humber.project.domain.Tracking;
import org.humber.project.services.TrackingService;
import org.springframework.stereotype.Service;

@Service
public class TrackingServiceImpl implements TrackingService {

    @Override
    public Tracking createTracking(Tracking tracking) {
        // Implement creation logic if needed
        return null;
    }

    @Override
    public boolean deleteTracking(Long trackingId) {
        // Implement deletion logic if needed
        return false;
    }

    @Override
    public Tracking updateDeliveryTime(Long trackingId, int deliveryTime) {
        // Implement updating delivery time logic without using JPARepo
        return null;
    }

    @Override
    public Tracking getTracking(Long trackingId) {
        // Implement retrieval logic if needed
        return null;
    }
}
