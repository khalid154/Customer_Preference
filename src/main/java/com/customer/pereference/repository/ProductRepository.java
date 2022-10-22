package com.customer.pereference.repository;

import com.customer.pereference.model.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Products, Long> {

    List<Products> findByManufactureRoleCategoryId(long manufactureRoleCategoryId);
}
