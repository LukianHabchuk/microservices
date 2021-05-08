package com.lukian.creditmicroservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDTO {
    private String firstName;
    private String pesel;//11 sybols
    private String surname;
}
