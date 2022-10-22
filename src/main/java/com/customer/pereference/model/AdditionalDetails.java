package com.customer.pereference.model;

import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.File;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "Additional_Details")
public class AdditionalDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long customerId;
    private Long categoryId;
    private List<Long> segmentIds;
    private List<Long> productIds;
    private boolean haveDigitalStore;
    private String digitalStoreLink;
    private File productCatalog;
    private String brandName;
    private List<String> competitorBrands;
    private boolean haveInternalDesignTeam;
    private List<String> platformsUsedToDesignProducts;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;
}
