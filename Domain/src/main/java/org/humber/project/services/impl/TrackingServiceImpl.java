package org.humber.project.services.impl;

import org.humber.project.domain.Tracking;
import org.humber.project.services.TrackingJPAService;
import org.humber.project.services.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackingServiceImpl implements TrackingService {

    private final TrackingJPAService trackingJPAService;

    @Autowired
    public TrackingServiceImpl(TrackingJPAService trackingJPAService) {
        this.trackingJPAService = trackingJPAService;
    }

    @Override
    public Tracking createTracking(Tracking tracking) {
        return trackingJPAService.save(tracking);
    }

    @Override
    public boolean deleteTracking(Long trackingId) {
        return trackingJPAService.deleteById(trackingId);
    }

    @Override
    public Tracking updateTracking(Tracking tracking) {
        return trackingJPAService.save(tracking);
    }

    @Override
    public Tracking getTracking(Long trackingId) {
        return trackingJPAService.findById(trackingId)
                .orElseThrow(() -> new RuntimeException("Tracker not found with ID: " + trackingId));
    }
}
