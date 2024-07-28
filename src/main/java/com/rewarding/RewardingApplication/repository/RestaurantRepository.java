package com.rewarding.RewardingApplication.repository;

import com.rewarding.RewardingApplication.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
Restaurant findByMerchantNumber(String merchantNumber);
}
