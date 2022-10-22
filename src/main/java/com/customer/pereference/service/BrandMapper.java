package com.customer.pereference.service;

import com.customer.pereference.model.Brands;
import com.customer.pereference.response.BrandBO;

import java.util.List;

public class BrandMapper {
    public BrandBO convertBrandsToBrandsBo(Brands brands) {
        //todo set brand details
        BrandBO brandBO = new BrandBO();
        brandBO.setName(brands.getName());
        return brandBO;
    }
}
