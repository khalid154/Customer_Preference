package com.customer.pereference.service;

import com.customer.pereference.model.AdditionalDetails;
import com.customer.pereference.request.AdditionalDetailsDto;

import java.util.List;

public class PreferenceMapper {


    public static AdditionalDetails getAdditionalDetailsFromRequest(AdditionalDetailsDto request) {
        AdditionalDetails additionalDetails = new AdditionalDetails();
        additionalDetails.setCustomerId(request.getCustomerId());
        additionalDetails.setCategoryId(request.getCategoryId());
        additionalDetails.setSegmentIds(request.getSegmentIds());
        additionalDetails.setProductIds(request.getProductIds());
        additionalDetails.setHaveDigitalStore(request.isHaveDigitalStore());
        additionalDetails.setDigitalStoreLink(request.getDigitalStoreLink());
//        additionalDetails.setProductCatalog(request.getProductCatalog());
        additionalDetails.setBrandName(request.getBrandName());
        additionalDetails.setCompetitorBrands(request.getCompetitorBrands());
        additionalDetails.setHaveInternalDesignTeam(request.isHaveInternalDesignTeam());
        additionalDetails.setPlatformsUsedToDesignProducts(request.getPlatformsUsedToDesignProducts());
        return additionalDetails;
    }
}
