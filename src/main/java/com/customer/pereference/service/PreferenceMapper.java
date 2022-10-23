package com.customer.pereference.service;

import com.customer.pereference.model.AdditionalDetails;
import com.customer.pereference.request.AdditionalDetailsDto;
import com.customer.pereference.util.StringUtil;

import java.util.List;

public class PreferenceMapper {


    public static AdditionalDetails getAdditionalDetailsFromRequest(AdditionalDetailsDto request) {
        AdditionalDetails additionalDetails = new AdditionalDetails();
        additionalDetails.setCustomerId(request.getCustomerId());
        additionalDetails.setCategoryId(request.getCategoryId());
        additionalDetails.setSegmentIds(StringUtil.getStringFromIntegerList(request.getSegmentIds()));
        additionalDetails.setProductIds(StringUtil.getStringFromIntegerList(request.getProductIds()));
        additionalDetails.setHaveDigitalStore(request.isHaveDigitalStore());
        additionalDetails.setDigitalStoreLink(request.getDigitalStoreLink());
//        additionalDetails.setProductCatalog(request.getProductCatalog());
        additionalDetails.setBrandName(request.getBrandName());
        additionalDetails.setCompetitorBrands(StringUtil.getStringFromList(request.getCompetitorBrands()));
        additionalDetails.setHaveInternalDesignTeam(request.isHaveInternalDesignTeam());
        additionalDetails.setPlatformsUsedToDesignProducts(StringUtil.getStringFromList(request.getPlatformsUsedToDesignProducts()));
        return additionalDetails;
    }
}
