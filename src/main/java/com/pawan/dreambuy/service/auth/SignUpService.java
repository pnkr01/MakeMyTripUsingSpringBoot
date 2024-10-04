//package com.pawan.dreambuy.service.auth;
//
//import com.pawan.dreambuy.controller.auth.SignupController;
//import com.pawan.dreambuy.controller.wallet.WalletRepository;
//import com.pawan.dreambuy.model.Wallet;
//import com.pawan.dreambuy.model.auth.UserRegistration;
//import com.pawan.dreambuy.repository.auth.SignUpRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
////TODOS: in progress
//
//public class SignUpService {
//    @Autowired
//    private SignUpRepository signUpRepository;
//    @Autowired
//    private WalletRepository walletRepository;
//    @Autowired
//    private PasswordEncoder encoder;
//
//    private static Logger logger = LoggerFactory.getLogger(SignupController.class);
//    private static PasswordEncoder passwordEncoder;
//
//    public static void handleSignUpFlow(WalletRepository walletRepository, UserRegistration user, SignUpRepository signUpRepository){
//        logger.info("inside signup service.java");
//        String hashPassword = passwordEncoder.encode(user.getUserPassword());
//        //check in login
//        //boolean isPasswordMatch = passwordEncoder.matches(rawPassword, encodedPasswordFromDB);
//
//        Wallet wallet = new Wallet();
//        wallet.setWalletBalance(100000.0F); // Assuming there's a method to set balance
//        wallet.setWalletHistory("First Credit");
//        walletRepository.save(wallet);
//        user.setUserWalletId(wallet.getWalletId());
//        user.setUserPassword(hashPassword);
//        user.setUserStatus("active");
//        signUpRepository.save(user);
//    }
//}
