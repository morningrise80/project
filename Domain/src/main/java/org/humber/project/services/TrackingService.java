package org.humber.project.services;

import org.humber.project.domain.Tracking;

public interface TrackingService {

    Tracking createTracking(Tracking tracking);

    boolean deleteTracking(Long trackingId);

    Tracking updateDeliveryTime(Long trackingId, int deliveryTime);

    Tracking getTracking(Long trackingId);
    
}
