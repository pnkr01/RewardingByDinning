package com.rewarding.RewardingApplication.repository;

import com.rewarding.RewardingApplication.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByCreditCardNumber(String creditCardNumber);
}
