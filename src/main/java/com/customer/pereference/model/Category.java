package com.customer.pereference.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String categoryIcon;
    private String categoryName;
    private Long categoryStage;
    private boolean isNavigation;
    private Long parentId;
    private Long languageId;
}
