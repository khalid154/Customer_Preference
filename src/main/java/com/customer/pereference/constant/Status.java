package com.customer.pereference.constant;

/**
 * @author : Khalid Hasan
 */
public enum Status {
    Active(1L),
    Inactive(2L),
    Deleted(4L),
    BlackListed(5L),
    Live_for_bid(6L),
    Exit(7L),
    Success(8L),
    Failed(9L),
    Pending(10L),
    Cancelled(11L);
    String name;
    public Long value;

    Status(Long value) {
        this.value = value;
    }
}
