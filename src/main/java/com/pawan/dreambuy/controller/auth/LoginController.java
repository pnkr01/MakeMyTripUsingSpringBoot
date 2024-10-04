package com.pawan.dreambuy.controller.auth;

import com.pawan.dreambuy.model.auth.UserLoginModel;
import com.pawan.dreambuy.model.auth.UserRegistration;
import com.pawan.dreambuy.repository.auth.SignUpRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired
    private SignUpRepository signUpRepository;
    private PasswordEncoder passwordEncoder;
    private Logger logger = LoggerFactory.getLogger(getClass());

    public LoginController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "auth/login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(ModelMap modelMap, @Valid UserLoginModel userLoginModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            logger.info("Validation errors found ---->"+bindingResult);
            modelMap.addAttribute("error",bindingResult.toString());
            return "auth/login";
        }else{
            UserRegistration currentUser = signUpRepository.findByUserName(userLoginModel.getUserName());
            if(currentUser != null){
                //user exist
                boolean isPasswordMatch = passwordEncoder.matches(userLoginModel.getPassword(), currentUser.getUserPassword());
                if(isPasswordMatch){
                    modelMap.addAttribute("user",currentUser);
                    return "home/userhome";
                }
            }else{
                modelMap.addAttribute("error","User not exist, Please signup");
                return "/auth/signup";
            }
        }
        return "auth/login";
    }

}
