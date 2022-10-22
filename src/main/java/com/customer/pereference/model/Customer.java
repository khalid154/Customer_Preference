package com.customer.pereference.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.OffsetTime;

@Entity(name = "Customer")
@Data
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @NotNull
    @Column(name = "UserName")
    private String userName;

    @NotNull
    @Column(name = "Password")
    private String password;

    @NotNull
    @Column(name = "Phone_Number")
    private String phoneNumber;

    @Column(name = "Profile_Image_Link")
    private String profileLink;

    @NotNull
    @Column(name = "Full_Name")
    private String fullName;

    @Column(name = "status_id")
    private int statusId;

    @Column(name = "language_id")
    private int languageId;

    @CreationTimestamp
    @Column(name = "inserted_on")
    private OffsetTime insertedOn;

    @UpdateTimestamp
    @Column(name = "updated_on")
    private OffsetTime updatedOn;

}
