package com.lukian.creditmicroservice.entity;

import com.lukian.creditmicroservice.dto.CreditDTO;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true, updatable = false)
    private int id;
    private String name;

    public CreditDTO parseCreditDTO() {
        return new CreditDTO(name);
    }
}
