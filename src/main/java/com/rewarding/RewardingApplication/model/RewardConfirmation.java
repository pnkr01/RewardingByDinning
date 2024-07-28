package com.rewarding.RewardingApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Setter;

@Entity
public class RewardConfirmation {
    @Id
    private long id;
    @Setter
    private String confirmationNumber;
    @Setter
    private double contribution;

}
