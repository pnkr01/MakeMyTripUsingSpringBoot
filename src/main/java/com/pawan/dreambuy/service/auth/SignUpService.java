package com.pawan.dreambuy.service.auth;

import com.pawan.dreambuy.config.configs.Config;
import com.pawan.dreambuy.controller.wallet.WalletRepository;
import com.pawan.dreambuy.model.Wallet;
import com.pawan.dreambuy.model.auth.UserRegistration;
import com.pawan.dreambuy.repository.auth.SignUpRepository;
import com.pawan.dreambuy.service.wallet.WalletService;
import jakarta.servlet.http.HttpServletRequest;
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
    @Autowired
    private Config config;

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser( UserRegistration user,HttpServletRequest request){
       return setNewUserField(user,request);
    }

    private String setNewUserField(UserRegistration user,HttpServletRequest request) {
        String hashPassword = passwordEncoder.encode(user.getUserPassword());
        int walletId = walletService.createNewWallet(100000.0F,"First Credit");
        setUser(user, walletId, hashPassword);
        signUpRepository.save(user);
        config.setSessionAttribute(request, user);

        return "home/userhome";
    }

    private static void setUser(UserRegistration user, int walletId, String hashPassword) {
        user.setUserWalletId(walletId);
        user.setUserPassword(hashPassword);
        user.setUserStatus("active");
    }


    public String handleUserAlreadyRegistered(ModelMap modelMap){
        modelMap.addAttribute("error", "User already exists. Please log in.");
        return "auth/login";
    }
}
