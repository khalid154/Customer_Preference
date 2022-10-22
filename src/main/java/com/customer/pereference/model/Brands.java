package com.customer.pereference.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "Brands")
public class Brands {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String thumbnails;
    private Date addedOn;
    private Date updatedOn;
    private Float averageRating;

    private String basedIn;

    private String bestSellingSku;

    private String coverPic;

    private String logo;

    private String longDesc;

    private String oneLiner;

    private String sortStory;

    private String tags;

    private boolean isActive;

    private long sortOrder;

    private boolean isFeatured;

    private Long languageId;

    @JoinColumn(name = "customer_id")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Customer customer;
}
