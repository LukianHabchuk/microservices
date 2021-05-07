package com.lukian.creditmicroservice.entity;

import com.lukian.creditmicroservice.dto.ProductDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    private String name;
    private int value;
    private int creditId;

    public Product(ProductDTO product, int creditId) {
        this.creditId = creditId;
        this.name = product.getName();
        this.value = product.getValue();
    }

    public ProductDTO parseProductDTO() {
        return new ProductDTO(name, value);
    }
}
