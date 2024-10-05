package com.pawan.dreambuy.service.wallet;

import com.pawan.dreambuy.controller.wallet.WalletRepository;
import com.pawan.dreambuy.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private Wallet wallet;

    @Autowired
    private WalletRepository walletRepository;

    public String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean matchPassword(String password, String hashedPassword) {
        return passwordEncoder.matches(password, hashedPassword);
    }

    public int createNewWallet(float walletBalance, String walletHistory){
        wallet.setWalletBalance(walletBalance);
        wallet.setWalletHistory(walletHistory);
        walletRepository.save(wallet);
        return wallet.getWalletId();
    }
}
