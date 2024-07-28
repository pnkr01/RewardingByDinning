package com.rewarding.RewardingApplication.controller;

import com.rewarding.RewardingApplication.model.Account;
import com.rewarding.RewardingApplication.model.Dining;
import com.rewarding.RewardingApplication.model.RewardConfirmation;
import com.rewarding.RewardingApplication.repository.AccountRepository;
import com.rewarding.RewardingApplication.service.RewardNetworkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rewards")
public class RewardController {

    private final RewardNetworkService rewardNetworkService;
    private final AccountRepository accountRepository;

    public RewardController(RewardNetworkService rewardNetworkService, AccountRepository accountRepository) {
        this.rewardNetworkService = rewardNetworkService;
        this.accountRepository = accountRepository;
    }

    @PostMapping("/getRewards")
    public RewardConfirmation rewardAccount(@RequestBody Dining dining) {
        return rewardNetworkService.rewardAccountFor(dining);
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
