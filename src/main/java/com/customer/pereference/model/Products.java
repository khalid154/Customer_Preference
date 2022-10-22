package com.customer.pereference.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity(name = "Products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String uuid;
    private Long countryId;
    private String previewImage;
    private String productName;
    private String productString;
    private Long brandModelCategoryId;
    private Long manufactureRoleCategoryId;
    private String legalDisclaimerDescription;
    private String manufacturerContactNumber;
    private String productSku;
    private Date createdOn;
    private Date updatedOn;
}
