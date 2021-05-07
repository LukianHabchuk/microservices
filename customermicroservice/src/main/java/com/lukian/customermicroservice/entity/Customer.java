package com.lukian.customermicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Customer {
    @Id
    @Column(nullable = false, unique = true, updatable = false)
    private int creditId;
    private String firstName;
    private String pesel;
    private String surname;//the data model in the example was called "surname", but it would be better "lastName"
}
