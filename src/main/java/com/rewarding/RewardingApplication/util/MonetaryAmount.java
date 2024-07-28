package com.rewarding.RewardingApplication.util;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class MonetaryAmount {
    @Getter
    @Setter
    private BigDecimal amount;

    public MonetaryAmount(BigDecimal amount) {
        this.amount = amount.setScale(2, 6);
    }

    // Getters and methods
}