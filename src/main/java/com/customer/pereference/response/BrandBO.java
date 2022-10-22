package com.customer.pereference.response;


import com.customer.pereference.model.Customer;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BrandBO implements Comparable<BrandBO>{
	private Long id;
	private String name;
	private String thumbnails;
	private String brandLogo;
	private String brandCoverPic;
	private String basedIn;
	private String shipsFrom;
	private String oneLiner;
	private String tags;
	private String shortStory;
	private String longDescription;
	private Long supplierId;
	private List<Customer> customers;
	private Integer noOfSupplier;
	@JsonFormat(pattern ="dd-MM-yyyy")
	private Date addedOn;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date updatedOn;
	private String adminId;
	private Float avgRating;
	private Boolean isActive;
//	private List<BrandReviewsBO> brandReviews;
	private List<String> categoryNameList;
	private String bestSellingSKU;
	private Boolean isFeatured;
	private Long sortOrder;
	private String sameManufacturerAs;
	private Boolean isUserLoginRequired;
	private Boolean isPremiumBrand;
	private Boolean isUserBelongToBrand;

	@Override
	public int compareTo(BrandBO o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}
}
