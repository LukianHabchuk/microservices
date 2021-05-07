package com.lukian.productmicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Product {
    @Id
    @Column(nullable = false, unique = true, updatable = false)
    private int creditId;
    private String name;
    private int value;
}
