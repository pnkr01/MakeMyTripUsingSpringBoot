package com.pawan.dreambuy.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int walletId;
    private float walletBalance;
    private String walletHistory;

    public Wallet(int walletId, float walletBalance, String walletHistory) {
        this.walletId = walletId;
        this.walletBalance = walletBalance;
        this.walletHistory = walletHistory;
    }

    public Wallet() {

    }

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public float getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(float walletBalance) {
        this.walletBalance = walletBalance;
    }

    public String getWalletHistory() {
        return walletHistory;
    }

    public void setWalletHistory(String walletHistory) {
        this.walletHistory = walletHistory;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "walletId=" + walletId +
                ", walletBalance=" + walletBalance +
                ", walletHistory='" + walletHistory + '\'' +
                '}';
    }
}
