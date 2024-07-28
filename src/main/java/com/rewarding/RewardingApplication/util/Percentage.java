package com.rewarding.RewardingApplication.util;

import lombok.Getter;

import java.math.BigDecimal;

public class Percentage {
    @Getter
    private BigDecimal percentage;

    public Percentage(BigDecimal percentage) {
        this.percentage = percentage.setScale(2, 6);
    }

    // Getters and methods
}