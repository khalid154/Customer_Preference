package com.customer.pereference.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "Brand_Model_Category")
public class BrandModelCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String categoryName;

    private String name;

    private Long brandModelId;

    private Long categoryId;

    private String displayName;

    private Long languageId;
}
