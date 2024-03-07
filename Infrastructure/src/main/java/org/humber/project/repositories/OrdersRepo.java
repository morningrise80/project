package org.humber.project.repositories;

import org.humber.project.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo extends JpaRepository<Orders, Integer> {
}
