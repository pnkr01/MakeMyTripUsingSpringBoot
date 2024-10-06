package com.pawan.dreambuy.controller.auth;
import com.pawan.dreambuy.model.Wallet;
import com.pawan.dreambuy.model.auth.UserRegistration;
import com.pawan.dreambuy.repository.auth.SignUpRepository;
import com.pawan.dreambuy.service.auth.SignUpService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Transactional
@Controller
public class SignupController {


    private final Logger  logger = LoggerFactory.getLogger(getClass());
    private final SignUpService signUpService;
    private final SignUpRepository signUpRepository;

    public SignupController(SignUpRepository signUpRepository, SignUpService signUpService) {
        super();
        this.signUpRepository=signUpRepository;
        this.signUpService=signUpService;
    }

    @RequestMapping(value = "signup",method = RequestMethod.GET)
    public String signup(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserRegistration userRegistration = (UserRegistration) session.getAttribute("loggedInUser");
        if(userRegistration==null){
            return "auth/signup";
        }
        return "redirect:/home";
    }
//
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String signUp(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserRegistration userRegistration = (UserRegistration) session.getAttribute("loggedInUser");
        if(userRegistration==null){
            return "auth/login";
        }
        return "redirect:/home";
    }


    @RequestMapping(value = "signup",method = RequestMethod.POST)
    public String signup(HttpServletRequest request,ModelMap modelMap, @Valid UserRegistration user, BindingResult result, HttpSession session){
        if(signUpRepository.findByUserName(user.getUserName()) !=null){
           return signUpService.handleUserAlreadyRegistered(modelMap);
        }else{
           return signUpService.registerUser(user,request);
        }
    }
}
