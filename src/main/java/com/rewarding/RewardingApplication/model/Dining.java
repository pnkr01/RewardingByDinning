package com.rewarding.RewardingApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
public class Dining {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Setter
    @Getter
    private String creditCardNumber;
    @Setter
    @Getter
    private String merchantNumber;
    @Setter
    @Getter
    private double amount;
    @Setter
    @Getter
    private LocalDate localDate;

    //getter and setter

    public Dining() {
        this.creditCardNumber = creditCardNumber;
        this.merchantNumber = merchantNumber;
    }
}
