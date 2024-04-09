package org.humber.project.repositories;

import org.humber.project.repositories.entities.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentJPARepository extends JpaRepository<PaymentEntity, Long> {

}
