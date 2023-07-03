package org.learning.java.springlamiapizzeriacrud.repository;

import org.learning.java.springlamiapizzeriacrud.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Integer> {
}
