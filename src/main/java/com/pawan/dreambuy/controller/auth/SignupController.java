package com.pawan.dreambuy.controller.auth;
import com.pawan.dreambuy.controller.wallet.WalletRepository;
import com.pawan.dreambuy.model.Wallet;
import com.pawan.dreambuy.model.auth.UserRegistration;
import com.pawan.dreambuy.repository.auth.SignUpRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignupController {


    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;
    private final SignUpRepository signUpRepository;
    private final WalletRepository walletRepository;

    public SignupController(SignUpRepository signUpRepository, WalletRepository walletRepository) {
        super();
        this.signUpRepository = signUpRepository;
        this.walletRepository = walletRepository;
    }

    @RequestMapping(value = "signup",method = RequestMethod.GET)
    public String signup(){
        return "/auth/signup";
    }

    @Transactional
    @RequestMapping(value = "signup",method = RequestMethod.POST)
    public String signup(ModelMap modelMap, @Valid UserRegistration user, BindingResult result){
        logger.info("debiggg ->"+user.toString()+" model map ->"+modelMap+" result ->"+result);
        logger.info(String.valueOf("user is "+signUpRepository.findByUserName(user.getUserName()) !=null));
        if(signUpRepository.findByUserName(user.getUserName()) !=null){
            //old user show that user already exist.
            logger.info("inside first loop---------------------------->"+signUpRepository.findByUserName(user.getUserName()));
            return "/auth/signup";
        }else{
            logger.info("inside second loop---------------------------->");
            String hashPassword = passwordEncoder.encode(user.getUserPassword());
            //check in login
            //boolean isPasswordMatch = passwordEncoder.matches(rawPassword, encodedPasswordFromDB);
            Wallet wallet = new Wallet();
            wallet.setWalletBalance(100000.0F); // Assuming there's a method to set balance
            wallet.setWalletHistory("First Credit");
            walletRepository.save(wallet);
            user.setUserWalletId(wallet.getWalletId());
            user.setUserPassword(hashPassword);
            user.setUserStatus("active");

// Save the user
            signUpRepository.save(user);

            return "/home/userhome";
        }
    }

}
