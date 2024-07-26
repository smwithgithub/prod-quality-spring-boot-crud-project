package com.sm.ecommerce.bs_ecom.repositories;

import com.sm.ecommerce.bs_ecom.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
