package com.rewarding.RewardingApplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter
    private String creditCardNumber;
    @OneToMany(cascade = CascadeType.ALL)
    @Getter
    private Set<Beneficiary> beneficiaries;
    //getter and setter
}
