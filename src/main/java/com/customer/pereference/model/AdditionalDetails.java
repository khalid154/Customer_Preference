package com.customer.pereference.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.File;
import java.util.Date;

@Data
@Entity(name = "Additional_Details")
public class AdditionalDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long customerId;
    private Long categoryId;
    private String segmentIds;
    private String productIds;
    private boolean haveDigitalStore;
    private String digitalStoreLink;
    private File productCatalog;
    private String brandName;
    private String competitorBrands;
    private boolean haveInternalDesignTeam;
    private String platformsUsedToDesignProducts;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;
}
