package com.rewarding.RewardingApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String merchantNumber;
    private double benefitPercentage;

    public double calculateBenefitPercentage(double amount) {
        return amount*benefitPercentage/100;
    }
}
