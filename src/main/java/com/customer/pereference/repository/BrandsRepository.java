package com.customer.pereference.repository;

import com.customer.pereference.model.Brands;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BrandsRepository extends CrudRepository<Brands, Long> {
    List<Brands> findByNameLike(String brandName);

    List<Brands> findBrandByCustomerId(Long customerId);

    Brands findByName(String name);
}
