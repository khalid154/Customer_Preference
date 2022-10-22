package com.customer.pereference.repository;

import com.customer.pereference.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
