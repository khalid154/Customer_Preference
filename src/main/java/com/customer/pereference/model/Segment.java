package com.customer.pereference.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Segment")
public class Segment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private Long categoryId;
    private String name;
    private Long statusId;
}
