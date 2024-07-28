package com.rewarding.RewardingApplication.repository;

import com.rewarding.RewardingApplication.model.RewardConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RewardRepository extends JpaRepository<RewardConfirmation,Long> {
}
