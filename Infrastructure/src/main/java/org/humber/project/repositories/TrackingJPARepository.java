package org.humber.project.repositories;

import org.humber.project.repositories.entities.TrackingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingJPARepository extends JpaRepository<TrackingEntity, Long> {

}
