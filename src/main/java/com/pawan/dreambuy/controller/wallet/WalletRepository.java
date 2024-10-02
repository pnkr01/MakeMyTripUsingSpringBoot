package com.pawan.dreambuy.controller.wallet;

import com.pawan.dreambuy.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Integer> {
}
