package com.lukian.creditmicroservice.entity;

import com.lukian.creditmicroservice.dto.CustomerDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    private int creditId;
    private String firstName;
    private String pesel;
    private String surname;//the data model in the example was called "surname", but it would be better "lastName"

    public Customer(int creditId, CustomerDTO customer) {
        this.creditId = creditId;
        this.firstName = customer.getFirstName();
        this.pesel = customer.getPesel();
        this.surname = customer.getSurname();
    }

    public CustomerDTO parseCustomerDTO() {
        return new CustomerDTO(firstName, pesel, surname);
    }
}
