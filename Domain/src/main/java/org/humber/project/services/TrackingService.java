package org.humber.project.services;

import org.humber.project.domain.Tracking;

public interface TrackingService {

    Tracking createTracking(Tracking tracking);

    boolean deleteTracking(Long trackingId);

    Tracking updateTracking(Tracking tracking);

    Tracking getTracking(Long trackingId);
}
