package com.pawan.dreambuy.service.auth;

import com.pawan.dreambuy.controller.wallet.WalletRepository;
import com.pawan.dreambuy.model.Wallet;
import com.pawan.dreambuy.model.auth.UserRegistration;
import com.pawan.dreambuy.repository.auth.SignUpRepository;
import com.pawan.dreambuy.service.wallet.WalletService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;


//TODOS: in progress

@Transactional
@Service
public class SignUpService {
    @Autowired
    private SignUpRepository signUpRepository;
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private Wallet wallet;
    @Autowired
    private WalletService walletService;

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser( UserRegistration user){
        setNewUserField(user);
    }

    private void setNewUserField(UserRegistration user) {
        String hashPassword = passwordEncoder.encode(user.getUserPassword());
        int walletId = walletService.createNewWallet(100000.0F,"First Credit");
        setUser(user, walletId, hashPassword);
        signUpRepository.save(user);
    }

    private static void setUser(UserRegistration user, int walletId, String hashPassword) {
        user.setUserWalletId(walletId);
        user.setUserPassword(hashPassword);
        user.setUserStatus("active");
    }


    public void handleUserAlreadyRegistered(ModelMap modelMap){
        modelMap.addAttribute("error", "User already exists. Please log in.");
    }
}
