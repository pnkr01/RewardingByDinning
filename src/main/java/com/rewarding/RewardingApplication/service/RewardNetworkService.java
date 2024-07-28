package com.rewarding.RewardingApplication.service;

import com.rewarding.RewardingApplication.model.Account;
import com.rewarding.RewardingApplication.model.Dining;
import com.rewarding.RewardingApplication.model.Restaurant;
import com.rewarding.RewardingApplication.model.RewardConfirmation;
import com.rewarding.RewardingApplication.repository.AccountRepository;
import com.rewarding.RewardingApplication.repository.RestaurantRepository;
import com.rewarding.RewardingApplication.repository.RewardRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RewardNetworkService {
    private static final Logger logger = LoggerFactory.getLogger(RewardNetworkService.class);

    private final AccountRepository accountRepository;
    private final RestaurantRepository restaurantRepository;
    private final RewardRepository rewardRepository;

    public RewardNetworkService(AccountRepository accountRepository, RestaurantRepository restaurantRepository, RewardRepository rewardRepository){
        this.accountRepository = accountRepository;
        this.restaurantRepository = restaurantRepository;
        this.rewardRepository = rewardRepository;
    }

    @Transactional
    public RewardConfirmation rewardAccountFor(Dining dining){
        Account account = accountRepository.findByCreditCardNumber(dining.getCreditCardNumber());
        Restaurant restaurant = restaurantRepository.findByMerchantNumber(dining.getMerchantNumber());

        if (account == null) {
            throw new IllegalArgumentException("Account not found for credit card number: " + dining.getCreditCardNumber());
        }

        if (restaurant == null) {
            throw new IllegalArgumentException("Restaurant not found for merchant number: " + dining.getMerchantNumber());
        }

        double benefit = restaurant.calculateBenefitPercentage(dining.getAmount());

        if (account.getBeneficiaries().isEmpty()) {
            throw new IllegalStateException("No beneficiaries found for account: " + dining.getCreditCardNumber());
        }

        account.getBeneficiaries().forEach(beneficiary -> {
            beneficiary.setAllocationPercentage(beneficiary.getAllocationPercentage() + benefit / account.getBeneficiaries().size());
        });

        accountRepository.save(account);
        logger.info("Updated Account: {}", account);

        RewardConfirmation rewardConfirmation = new RewardConfirmation();
        rewardConfirmation.setConfirmationNumber("CONF12345");
        rewardConfirmation.setContribution(benefit);

        rewardRepository.save(rewardConfirmation);

        return rewardConfirmation;
    }
}
