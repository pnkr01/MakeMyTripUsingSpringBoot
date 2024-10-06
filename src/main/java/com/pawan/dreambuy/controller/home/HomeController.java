package com.pawan.dreambuy.controller.home;

import com.pawan.dreambuy.model.auth.UserLoginModel;
import com.pawan.dreambuy.model.auth.UserRegistration;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
    @GetMapping(value = "home")
    public String home(HttpServletRequest  request) {

        HttpSession session = request.getSession();
        UserRegistration user = (UserRegistration) session.getAttribute("loggedInUser");
        if(user == null) {
            return "redirect:/login";
        }
        return "home/userhome";
    }
}
