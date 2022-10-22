package com.customer.pereference.repository;

import com.customer.pereference.model.Segment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SegmentRepository extends CrudRepository<Segment, Long> {

    List<Segment> findByCategoryIdAndStatusId(Long categoryId, Long statusId);
}
