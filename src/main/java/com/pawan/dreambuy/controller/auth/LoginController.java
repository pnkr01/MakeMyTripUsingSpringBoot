package com.pawan.dreambuy.controller.auth;

import com.pawan.dreambuy.config.configs.Config;
import com.pawan.dreambuy.model.auth.UserLoginModel;
import com.pawan.dreambuy.model.auth.UserRegistration;
import com.pawan.dreambuy.repository.auth.SignUpRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RestController;


@Controller
public class LoginController {
    @Autowired
    private SignUpRepository signUpRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private Config config;
    private final Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(HttpServletRequest request){
        boolean isUserLoggedIn = config.checkIsAnyCurrentUserLoggedIn(request);
        if(isUserLoggedIn){
            return "redirect:/home";
        }else{
            return "auth/login";
        }
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, ModelMap modelMap, @Valid UserLoginModel userLoginModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return handleBindingError(modelMap, bindingResult);
        }else{
            UserRegistration currentUser = findUserIfExistWithThisFields(userLoginModel);
            if(checkIfUserFoundInDbWithCurrentUser(currentUser)){
                boolean isPasswordMatch = hashAndMatchUserPasswordFromDB(userLoginModel, currentUser);
                if(isPasswordMatch){
                    return makeThisUserToLogin(request, modelMap, currentUser);
                }else{
                    return handlePasswordNotMatchedError(modelMap);
                }
            }else{
                return handleUserNotRegisteredError(modelMap);
            }
        }
    }

    private static boolean checkIfUserFoundInDbWithCurrentUser(UserRegistration currentUser) {
        return currentUser != null;
    }

    private UserRegistration findUserIfExistWithThisFields(UserLoginModel userLoginModel) {
        UserRegistration currentUser = signUpRepository.findByUserName(userLoginModel.getUserName());
        return currentUser;
    }

    private static String handleBindingError(ModelMap modelMap, BindingResult bindingResult) {
        modelMap.addAttribute("error", bindingResult.toString());
        return "auth/login";
    }

    private boolean hashAndMatchUserPasswordFromDB(UserLoginModel userLoginModel, UserRegistration currentUser) {
        boolean isPasswordMatch = passwordEncoder.matches(userLoginModel.getPassword(), currentUser.getUserPassword());
        return isPasswordMatch;
    }

    private static String handlePasswordNotMatchedError(ModelMap modelMap) {
        modelMap.addAttribute("error","Username or password is incorrect");
        return "auth/login";
    }

    private String handleUserNotRegisteredError(ModelMap modelMap) {
        modelMap.addAttribute("error","User not exist, Please signup");
        return "auth/signup";
    }

    private String makeThisUserToLogin(HttpServletRequest request, ModelMap modelMap, UserRegistration currentUser) {
        config.setSessionAttribute(request, currentUser);
        modelMap.addAttribute("user", currentUser);
        return "redirect:home";
    }

}
