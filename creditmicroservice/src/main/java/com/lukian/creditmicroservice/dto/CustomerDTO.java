package com.lukian.creditmicroservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDTO {
    private String firstName;
    private String pesel;
    private String surname;
}
