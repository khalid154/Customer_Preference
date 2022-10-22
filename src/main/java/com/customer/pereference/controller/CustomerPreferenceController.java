package com.customer.pereference.controller;

import com.customer.pereference.constant.ErrorResponse;
import com.customer.pereference.request.AdditionalDetailsDto;
import com.customer.pereference.response.BrandBO;
import com.customer.pereference.response.RestApiResponse;
import com.customer.pereference.service.BrandService;
import com.customer.pereference.service.CustomerPreferenceService;
import com.customer.pereference.util.CompletableFutures;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletionStage;

@RequestMapping("/preference")
@RestController
@CrossOrigin
@Log4j2
public class CustomerPreferenceController {

    @Autowired
    private CustomerPreferenceService customerPreferenceService;

    @Autowired
    private BrandService brandService;

    @GetMapping("/segments/{categoryId}")
    public CompletionStage<RestApiResponse> getSegments(@PathVariable("categoryId") Long categoryId) {
        log.info("request received with categoryId = " + categoryId);
        return customerPreferenceService.getSegments(categoryId)
                .exceptionally(throwable -> {
                    Throwable unwrappedException = CompletableFutures.unwrapCompletionStageException(throwable);
                    log.info(unwrappedException.getMessage());
                    return RestApiResponse.builder()
                            .status(ErrorResponse.INTERNAL_SERVER_ERROR.code)
                            .message(ErrorResponse.INTERNAL_SERVER_ERROR.message)
                            .isSuccess(false)
                            .build();
                });
    }

    @GetMapping("/products/{categoryId}")
    public CompletionStage<RestApiResponse> getProducts(@PathVariable("categoryId") Long categoryId) {
        log.info("request received with categoryId = " + categoryId);
        return customerPreferenceService.getProducts(categoryId)
                .exceptionally(throwable -> {
                    Throwable unwrappedException = CompletableFutures.unwrapCompletionStageException(throwable);
                    log.info(unwrappedException.getMessage());
                    return RestApiResponse.builder()
                            .status(ErrorResponse.INTERNAL_SERVER_ERROR.code)
                            .message(ErrorResponse.INTERNAL_SERVER_ERROR.message)
                            .isSuccess(false)
                            .build();
                });
    }

    @PostMapping("/additionalDetails")
    public CompletionStage<RestApiResponse> saveAdditionalDetails(@RequestBody AdditionalDetailsDto request) {
        log.info("request received with additional details = " + request.toString());
        return customerPreferenceService.saveAdditionalDetails(request)
                .exceptionally(throwable -> {
                    Throwable unwrappedException = CompletableFutures.unwrapCompletionStageException(throwable);
                    log.info(unwrappedException.getMessage());
                    return RestApiResponse.builder()
                            .status(ErrorResponse.INTERNAL_SERVER_ERROR.code)
                            .message(ErrorResponse.INTERNAL_SERVER_ERROR.message)
                            .isSuccess(false)
                            .build();
                });
    }

//    @ApiOperation("It take brand name as a parameter and Will return all brand on basis of contains name like %brandName%")
//    @GetMapping(value = "/getBrandInfo")
//    public ResponseEntity<RestApiResponse> getBrandInfo(@RequestParam(value = "brandName", required = false) String brandName,
//                                                        @RequestHeader(name = "phonenumber", defaultValue = "0", required = false) String contact) {
//        log.info("getting info of brand name {}", brandName);
//        return getSuccessResponse(brandService.getBrandByName(brandName, contact), "Brand Fetched Successfully!");
//    }
//
//
//    @ApiOperation("It take brandId as a parameter and Will return all brand on basis of brandId")
//    @GetMapping(value = "/getBrandInfo/{brandId}")
//    public Object getBrandInfoById(@PathVariable(value = "brandId", required = false) String brandId) {
//        log.info("getting info of brand brandId {}", brandId);
//        return brandService.getBrandInfoById(brandId);
//    }
//
//
//    @ApiOperation("This Will give you All Brands")
//    @GetMapping(value = "/getAllBrands")
//    public ResponseEntity<RestApiResponse> getAllBrands(@RequestHeader("countrycode") String countryCode) {
//        log.info("getting getAllBrands");
//        return getSuccessResponse(brandService.getAllBrands(countryCode), "Brands Fetched Successfully!");
//    }
//
//    @ApiOperation("This Will give you All Brands")
//    @GetMapping(value = "/getAllBrandsForAdmin")
//    public ResponseEntity<RestApiResponse> getAllBrandsForAdmin(@RequestParam(value = "pageNum", required = false) Integer pageNum,
//                                                                @RequestParam(value = "pageSize", required = false) Integer pageSize,
//                                                                @RequestParam(value = "sortOrder", required = false) String sortOrder) {
//        log.info("getting getAllBrandsForAdmin");
//        return getSuccessResponse(brandService.getAllBrandsForAdmin(sortOrder, pageNum, pageSize), "Brands Fetched Successfully!");
//    }
//
//    @ApiOperation("Will use to save brand.")
//    @PostMapping(value = "/saveBrand")
//    public ResponseEntity<?> saveBrand(@RequestBody BrandBO brandBo) {
//        log.info("save brand Info invoked");
//        try {
//            String finalSku = "";
//            String[] sku = brandBo.getBestSellingSKU().trim().replaceAll("\n", ",").split(",");
//            if (sku.length > 0) {
//                for (int i = 0; i < sku.length; i++) {
//                    if (i < (sku.length - 1)) {
//                        finalSku = finalSku + sku[i].trim() + ",";
//                    } else {
//                        finalSku = finalSku + sku[i].trim();
//                    }
//                }
//            } else {
//                finalSku = brandBo.getBestSellingSKU().trim();
//            }
//
//            brandBo.setBestSellingSKU(finalSku);
//        } catch (Exception e) {
//
//        }
//		/*List<String> invalidSkus = brandService.isSKUValid(brandBo.getSupplierId(), brandBo.getBestSellingSKU());
//		if(invalidSkus.size()>0) {
//			return getErrorResponse(invalidSkus.toString(),"Given SKUs belong to a different Supplier");
//		}else {
//		return getsuccessResponse(brandService.save(brandBo),"Brand Saved Successfully!");
//		}
//*/
//        return getSuccessResponse(brandService.save(brandBo), "Brand Saved Successfully!");
//    }
//
//    @ApiOperation("Will use to Update brand.")
//    @PatchMapping(value = "/patch")
//    public ResponseEntity<?> patch(@RequestBody BrandBO brandBo) {
//        log.info("update brand Info invoked");
//        try {
//            String finalSku = "";
//            String[] sku = brandBo.getBestSellingSKU().trim().replaceAll("\n", ",").split(",");
//            if (sku.length > 0) {
//                for (int i = 0; i < sku.length; i++) {
//                    if (i < (sku.length - 1)) {
//                        finalSku = finalSku + sku[i].trim() + ",";
//                    } else {
//                        finalSku = finalSku + sku[i].trim();
//                    }
//                }
//            } else {
//                finalSku = brandBo.getBestSellingSKU().trim();
//            }
//
//            brandBo.setBestSellingSKU(finalSku);
//        } catch (Exception e) {
//
//        }
//
//        List<String> invalidSkus = brandService.isSKUValid(brandBo.getSupplierId(), brandBo.getBestSellingSKU());
//        if (invalidSkus.size() > 0) {
//            return getErrorResponse(invalidSkus.toString(), "Given SKUs belong to a different Supplier");
//        } else {
//            return getSuccessResponse(brandService.patch(brandBo), "Brand Updated Successfully!");
//        }
//    }
//
//    @ApiOperation("it take brandId as aparameter and setActive 0  which indicate product is inactive")
//    @PostMapping(value = "/deleteBrand")
//    public ResponseEntity<RestApiResponse> deleteBrand(@RequestParam long brandId) {
//        log.info("deleteBrand invoked");
//        return getSuccessResponse(brandService.changeActiveStatus(brandId, false), "Deleted Successfully.");
//    }
//
//    @ApiOperation("it take brandId as aparameter and setActive 1  which indicate product is active")
//    @PostMapping(value = "/activateBrand")
//    public ResponseEntity<RestApiResponse> activateBrand(@RequestParam long brandId) {
//        log.info("activateBrand invoked");
//        return getSuccessResponse(brandService.changeActiveStatus(brandId, true), "Status Changed Successfully !!");
//    }
//
//    @ApiOperation("will return all productCombination of brand sku")
//    @GetMapping(value = "/getAllPopularSku/{brandId}")
//    public ResponseEntity<RestApiResponse> getAllPopularSku(@PathVariable("brandId") long brandId, @RequestHeader("countrycode") String displayCountryCode) {
//        log.info("getAllPopularSku invoked brandId : {}", brandId);
//        return getSuccessResponse(brandService.getAllPopularSku(brandId, displayCountryCode));
//    }
//
//    @ApiOperation("will return all popular productCombination of brand best selling sku")
//    @GetMapping(value = "/getAllPopularSku")
//    public ResponseEntity<RestApiResponse> getAllPopularSku() {
//        log.info("getAllPopularSku invoked : {}");
//        return getSuccessResponse(brandService.getAllBestSellingSku());
//    }
//
//    @ApiOperation("Will Return All BrandModelCategory belongs from any supplier")
//    @GetMapping(value = "/getAllBrandsForSupplier/{supplierId}")
//    public ResponseEntity<RestApiResponse> getAllSupplierBrand(@PathVariable("supplierId") long supplierId) {
//        log.info("getAllSupplierBrand invoked brandId : {}", supplierId);
//        return getSuccessResponse(brandService.getAllSupplierBrand(supplierId));
//    }
//
//    @ApiOperation("Will Return All ProductCombination belongs from any brand")
//    @GetMapping(value = "/getAllProduct/{brandId}")
//    public ResponseEntity<RestApiResponse> getProductCombinationByBrand(@PathVariable("brandId") long brandId, @RequestParam(value = "pageNum", required = false) Integer pageNum,
//                                                                        @RequestParam(value = "pageSize", required = false) Integer pageSize,
//                                                                        @RequestParam(value = "sortOrder", required = false) String sortOrder) {
//        log.info("getProductCombinationByBrand invoked brandId : {}", brandId);
//        return getSuccessResponse(brandService.getProductCombinationByBrand(brandId, sortOrder, pageNum, pageSize));
//    }
//
//    @ApiOperation("Will Return All BrandModelCategory belongs from any brand")
//    @GetMapping(value = "/getbrandModelCategoryByBrand/{brandId}")
//    public ResponseEntity<RestApiResponse> getbrandModelCategoryByBrand(@PathVariable("brandId") long brandId) {
//        log.info("getbrandModelCategoryByBrand invoked brandId : {}", brandId);
//        return getSuccessResponse(brandService.getbrandModelCategoryByBrand(brandId));
//    }
//
////    @ApiOperation("it take brandId as paparameter and review object in requestparam and create review for brand")
////    @PostMapping(value = "/addReview/{brandId}")
////    public ResponseEntity<RestApiResponse> addReview(@PathVariable("brandId") long brandId, @RequestBody BrandReviewsBO brandReviewsBO) {
////        log.info("addReview invoked {}", brandId);
////        return getsuccessResponse(brandService.addReview(brandId, brandReviewsBO));
////    }
////
////    @ApiOperation("Will Return All Review belongs from any brand")
////    @GetMapping(value = "/getBrandReview/{brandId}")
////    public ResponseEntity<RestApiResponse> getBrandReview(@PathVariable("brandId") long brandId) {
////        log.info("getBrandReview invoked brandId : {}", brandId);
////        return getsuccessResponse(brandService.getBrandReview(brandId));
////    }
//
//    @ApiOperation("It take SupplierId as a parameter and Will return  brand on basis of supplierId")
//    @GetMapping(value = "/{supplierId}")
//    public ResponseEntity<RestApiResponse> getBrandInfoBySupplier(@PathVariable("supplierId") Long supplierId) {
//        log.info("getting info of brand of supplier {}", supplierId);
//        List<BrandBO> bo = null;
//        try {
//            bo = brandService.getBrandBySupplier(supplierId);
//            return getSuccessResponse(bo, "Brand Fetched Successfully!");
//        } catch (Exception e) {
//            return getSuccessResponse(bo, "supplier don't have brands");
//        }
//
//    }
//
//    @ApiOperation("will return Category and subcategory both")
//    @GetMapping(value = "/getAllCategory")
//    public ResponseEntity<String> getAllCategory(@RequestHeader("countrycode") String countryCode) {
//        log.info("getAllCategory invoked");
//        return ResponseEntity.ok(brandService.getAllCategory(countryCode, false));
//    }
//
//    @ApiOperation("will return Category and subcategory both with cache")
//    @GetMapping(value = "/refreshCategoriesInCache")
//    public ResponseEntity<String> refreshCategoriesInCache(@RequestHeader("countrycode") String countryCode) {
//        log.info("getAllCategory invoked");
//        return ResponseEntity.ok(brandService.getAllCategory(countryCode, true));
//    }
//
//    @ApiOperation("It will return all top level category")
//    @GetMapping(value = "/getTopCategory")
//    public ResponseEntity<RestApiResponse> getTopCategory() {
//        log.info("getAllCategory invoked");
//        return getSuccessResponse(brandService.getTopCategory(), "Category Fetched Successfully!");
//    }
//
//    @ApiOperation("It take categoryId as a parameter and Will return  all last level of catalogary")
//    @GetMapping(value = "/getSubCategoryById/{categoryId}")
//    public ResponseEntity<RestApiResponse> getSubCategoryById(@PathVariable("categoryId") Long categoryId, @RequestHeader("countrycode") String countryCode) {
//        log.info("getAllCategory invoked");
//        return getSuccessResponse(brandService.getAllCategory(categoryId, countryCode), "Category Fetched Successfully!");
//    }
//
//    @GetMapping(value = "/getAllBrandProduct/{brandId}")
//    public ResponseEntity<RestApiResponse> getAllBrandProduct(@PathVariable("brandId") Long brandId, @RequestParam(value = "displayCountryCode", required = false) String displayCountryCode) {
//        log.info("getAllBrandProduct invoked");
//        return getSuccessResponse(brandService.getAllBrandProduct(brandId, displayCountryCode, displayCountryCode), "Product Fetched Successfully!");
//    }
//
//    private ResponseEntity<RestApiResponse> getSuccessResponse(Object obj) {
//        return ResponseEntity.ok(new RestApiResponse(true, HttpStatus.OK.value(), "Success", obj));
//    }
//
//    private ResponseEntity<RestApiResponse> getSuccessResponse(Object obj, String msg) {
//        return ResponseEntity.ok(new RestApiResponse(true, HttpStatus.OK.value(), msg, obj));
//    }
//
//    private ResponseEntity<RestApiResponse> getErrorResponse(String obj, String msg) {
//        return ResponseEntity.ok(new RestApiResponse(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, obj));
//    }
//
//
//    @ApiOperation("will Flush Categories from Cache ")
//    @GetMapping(value = "/flushAllCategory")
//    public ResponseEntity<RestApiResponse> flushAllCategoryFromCache() {
//        log.info("flushAllCategory invoked");
//        brandService.flushCategoryCache();
//        return getSuccessResponse(null, "Category Flushed Successfully!");
//    }
//
//
//    @ApiOperation("add supplier to a brands")
//    @PostMapping("adddBrandToSupplier")
//    public Object addbrandToSupplier(@RequestParam("supplierEmail") String supplierEmail, @RequestParam("brandId") String brandId) {
//        log.info("inside addbrandToSupplier supplierId>>" + supplierEmail + "brandId>>" + brandId);
//        Object res = null;
//        try {
//            res = brandService.addBrandToSupplier(supplierEmail, brandId);
//            log.info("res for add supplier" + res);
//            return res;
//        } catch (Exception e) {
//            RestApiResponse successResponse = new RestApiResponse(false, HttpStatus.NOT_ACCEPTABLE.value(), "Couldn't add the brand to supplier", null);
//            log.error("error occur while adding the brand to the supplier>>", e);
//            return new ResponseEntity<>(successResponse, HttpStatus.OK);
//        }
//
//    }
//
//
//    @ApiOperation("remove supplier from a brands")
//    @PostMapping("removeBrandToSupplier")
//    public Object removeBrandToSupplier(@RequestParam("supplierId") String supplierId, @RequestParam("brandId") String brandId) {
//        log.info("inside removeBrandToSupplier supplierId>>" + supplierId + "brandId>>" + brandId);
//        Object res = null;
//        try {
//            res = brandService.removeBrandToSupplier(supplierId, brandId);
//            log.info("res for remove supplier" + res);
//            return res;
//        } catch (Exception e) {
//            RestApiResponse successResponse = new RestApiResponse(false, HttpStatus.NOT_ACCEPTABLE.value(), "Couldn't add the brand to supplier", null);
//            log.error("error occur while removing the brand to the supplier>>", e);
//            return new ResponseEntity<>(successResponse, HttpStatus.OK);
//        }
//
//    }
//
//    @ApiOperation("this api will be use for update the feature of brands")
//    @GetMapping("/updateSortOrderAndFeatured/{brandId}")
//    public Object updateSortOrderAndFeatured(@PathVariable("brandId") String brandId,
//                                             @RequestParam(value = "sortOrder", required = false) String sortOrder, @RequestParam(value = "isFeatured", required = false) Boolean isFeatured) {
//        log.info("inside the updateSortOrderAndFeatured");
//        Object res = null;
//        return brandService.updateSortOrderAndFeatured(brandId, sortOrder, isFeatured);
//
//    }
//
//    @ApiOperation("get All supplier of a brands")
//    @GetMapping("/getAllSupplierByBrand/{brandId}")
//    public Object getSupplier(@PathVariable("brandId") String brandId,
//                              @RequestParam(value = "pageNum", required = false) Integer pageNum,
//                              @RequestParam(value = "pageSize", required = false) Integer pageSize,
//                              @RequestParam(value = "sortOrder", required = false) String sortOrder) {
//        Object res = null;
//        try {
//            res = brandService.getSupplierByBrand(brandId, sortOrder, pageNum, pageSize);
//            log.info("res for get Supplier " + res);
//            return res;
//        } catch (Exception e) {
//            RestApiResponse successResponse = new RestApiResponse(true, HttpStatus.NOT_ACCEPTABLE.value(), "Couldn't get supplier ", null);
//            log.error("error occur while removing the brand to the supplier>>", e);
//            return new ResponseEntity<>(successResponse, HttpStatus.OK);
//        }
//
//    }
//
//    @ApiOperation("It take categoryId as a parameter and Will return  all level of catalogaries")
//    @GetMapping(value = "/getAllCategoriesAndSubCategory")
//    public ResponseEntity<RestApiResponse> getAllCategoriesAndSubCategories(@RequestHeader("countrycode") String countryCode) {
//        log.info("getAllCategory invoked");
//        return getSuccessResponse(brandService.getAllCategoriesAndSubCategories(countryCode), "Category Fetched Successfully!");
//    }
}
