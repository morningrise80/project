package org.humber.project.services;

import org.humber.project.domain.Tracking;

import java.util.Optional;

public interface TrackingJPAService {
    Tracking save(Tracking tracking);

    boolean deleteById(Long trackingId);

    Optional<Tracking> findById(Long trackingId);
}
