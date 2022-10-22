package com.customer.pereference.service;

import com.customer.pereference.constant.ErrorResponse;
import com.customer.pereference.constant.Status;
import com.customer.pereference.model.AdditionalDetails;
import com.customer.pereference.repository.AdditionalDetailsRepository;
import com.customer.pereference.repository.ProductRepository;
import com.customer.pereference.repository.SegmentRepository;
import com.customer.pereference.request.AdditionalDetailsDto;
import com.customer.pereference.response.RestApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Service
public class CustomerPreferenceService {

    @Autowired
    private SegmentRepository segmentRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    AdditionalDetailsRepository additionalDetailsRepository;

    public CompletionStage<RestApiResponse> getSegments(Long categoryId) {
        return CompletableFuture.supplyAsync(() -> {
            return segmentRepository.findByCategoryIdAndStatusId(categoryId, Status.Active.value);
        }).thenApply(res -> {
            return getRestApiResponse(res);
        });
    }

    public CompletionStage<RestApiResponse> getProducts(Long categoryId) {
        return CompletableFuture.supplyAsync(() -> {
            return productRepository.findByManufactureRoleCategoryId(categoryId);
        }).thenApply(res -> {
            return getRestApiResponse(res);
        });
    }

    public CompletionStage<RestApiResponse> saveAdditionalDetails(AdditionalDetailsDto request) {
        return CompletableFuture.supplyAsync(() -> {
            AdditionalDetails additionalDetails = PreferenceMapper.getAdditionalDetailsFromRequest(request);
            additionalDetailsRepository.save(additionalDetails);
            return "Success";
        }).thenApply(res -> {
            return getRestApiResponse(res);
        });
    }

    private RestApiResponse getRestApiResponse(Object object) {
        return RestApiResponse.builder()
                .status(ErrorResponse.SUCCESS.code)
                .message(ErrorResponse.SUCCESS.message)
                .data(object)
                .build();
    }
}
