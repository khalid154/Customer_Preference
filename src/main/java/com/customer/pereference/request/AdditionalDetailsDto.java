package com.customer.pereference.request;

import lombok.Data;

import java.util.List;

@Data
public class AdditionalDetailsDto {
    private Long customerId;
    private Long categoryId;
    private List<Long> segmentIds;
    private List<Long> productIds;
    private boolean haveDigitalStore;
    private String digitalStoreLink;
    //    private File productCatalog; // todo add file
    private String brandName;
    private List<String> competitorBrands;
    private boolean haveInternalDesignTeam;
    private List<String> platformsUsedToDesignProducts;
}
