package com.wallet.example.controller;


import com.wallet.example.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 *
 */
@RestController
@RequestMapping("/api")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping("/wallet/getRemainingSum")
    public Object getRemainingSum(String userId) {
        return walletService.getRemainingSum(userId);
    }

    @PostMapping("/wallet/spend")
    public Object spend(@RequestBody Map param) {
        return walletService.spend(param);
    }

    @PostMapping("/wallet/refund")
    public Object refund(@RequestBody Map param) {
        return walletService.refund(param);
    }

    @GetMapping("/wallet/getSpendDetail")
    public Object getSpendDetail(String query) {
        return walletService.getSpendDetail(query);
    }
}

